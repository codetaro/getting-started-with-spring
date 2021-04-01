package chapter13.bankapp.web;

import chapter13.bankapp.domain.FixedDepositDetails;
import chapter13.bankapp.service.FixedDepositService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

@Controller
@RequestMapping(value = "/fixedDeposit")
@Log4j
public class FixedDepositController {

    @Autowired
    private FixedDepositService fixedDepositService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Callable<ModelAndView> listFixedDeposits() {
        return new Callable<ModelAndView>() {
            @Override
            public ModelAndView call() throws Exception {
//                Thread.sleep(5000);
                ModelMap modelData = new ModelMap();
                modelData.put("fdList", fixedDepositService.getFixedDeposits());
                modelData.put("currentLocale", LocaleContextHolder.getLocale());
                return new ModelAndView("bankapp/fixedDepositList", modelData);
            }
        };
    }

    @RequestMapping(params = "fdAction=createFDForm", method = RequestMethod.POST)
    public ModelAndView showOpenFixedDepositForm() {
        FixedDepositDetails fixedDepositDetails = new FixedDepositDetails();
        fixedDepositDetails.setEmail("You must enter a valid email");
        ModelMap modelData = new ModelMap();
        modelData.addAttribute(fixedDepositDetails);
        return new ModelAndView("bankapp/createFixedDepositForm", modelData);
    }

    @RequestMapping(params = "fdAction=create", method = RequestMethod.POST)
    public String openFixedDeposit(
            @ModelAttribute(value = "newFixedDepositDetails") FixedDepositDetails fixedDepositDetails,
            BindingResult bindingResult) {

        new FixedDepositDetailsValidator().validate(fixedDepositDetails, bindingResult);

        if (bindingResult.hasErrors()) {
            log.info("openFixedDeposit() method: Validation errors - re-displaying form for opening a new fixed deposit");
            return "bankapp/createFixedDepositForm";
        } else {
            fixedDepositService.saveFixedDeposit(fixedDepositDetails);
            log.info("openFixedDeposit() method: Fixed deposit details successfully saved. Redirecting to show the list of fixed deposits.");
            return "redirect:/fixedDeposit/list";
        }
    }

    @RequestMapping(params = "fdAction=edit", method = RequestMethod.POST)
    public String editFixedDeposit(
            @ModelAttribute("editableFixedDepositDetails") FixedDepositDetails fixedDepositDetails,
            BindingResult bindingResult) {

        new FixedDepositDetailsValidator().validate(fixedDepositDetails, bindingResult);

        if (bindingResult.hasErrors()) {
            log.info("editFixedDeposit() method: Validation errors - re-displaying form for editing a fixed deposit");
            return "bankapp/editFixedDepositForm";
        } else {
            fixedDepositService.editFixedDeposit(fixedDepositDetails);
            log.info("editFixedDeposit() method: Fixed deposit successfully closed. Redirecting to show the list of fixed deposits.");
            return "redirect:/fixedDeposit/list";
        }
    }

    @RequestMapping(params = "fdAction=close", method = RequestMethod.GET)
    public String closeFixedDeposit(
            @RequestParam(value = "fixedDepositId") int fdId) {
        fixedDepositService.closeFixedDeposit(fdId);
        return "redirect:/fixedDeposit/list";
    }

    @RequestMapping(params = "fdAction=view", method = RequestMethod.GET)
    public ModelAndView viewFixedDepositDetails(
            @RequestParam(value = "fixedDepositId") FixedDepositDetails fixedDepositDetails) {

        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("editableFixedDepositDetails", fixedDepositDetails);
        log.info("viewFixedDepositDetails() method: Fixed deposit details loaded from data store. Showing form for editing the loaded fixed deposit.");
        return new ModelAndView("bankapp/editFixedDepositForm", modelMap);
    }

    @ExceptionHandler
    public String handleException(Exception ex) {
        return "error";
    }
}
