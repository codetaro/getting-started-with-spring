package chapter11.bankapp.web;

import chapter11.bankapp.domain.FixedDepositDetails;
import chapter11.bankapp.service.FixedDepositService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fixedDeposit")
@Log4j
@SessionAttributes(value = {"newFixedDepositDetails", "editableFixedDepositDetails"})
public class FixedDepositController {

    @Autowired
    private FixedDepositService fixedDepositService;

    @Autowired
    private Validator validator;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ModelAttribute(value = "fdList")
    public List<FixedDepositDetails> listFixedDeposits() {
        log.info("listFixedDeposits() method: Getting list of fixed deposits");
        return fixedDepositService.getFixedDeposits();
    }

    @ModelAttribute(value = "newFixedDepositDetails")
    public FixedDepositDetails getNewFixedDepositDetails() {
        FixedDepositDetails fixedDepositDetails = new FixedDepositDetails();
        fixedDepositDetails.setEmail("You must enter a valid email");
        log.info("getNewFixedDepositDetails() method: Returning a new instance of FixedDepositDetails");
        return fixedDepositDetails;
    }

    @RequestMapping(params = "fdAction=createFDForm", method = RequestMethod.POST)
    public String showOpenFixedDepositForm() {
        log.info("showOpenFixedDepositForm() method: Showing form for opening a new fixed deposit");
        return "createFixedDepositForm";
    }

    @RequestMapping(params = "fdAction=create", method = RequestMethod.POST)
    public String openFixedDeposit(
            @Valid @ModelAttribute(value = "newFixedDepositDetails") FixedDepositDetails fixedDepositDetails,
            BindingResult bindingResult, SessionStatus sessionStatus) {

        validator.validate(fixedDepositDetails, bindingResult);

        if (bindingResult.hasErrors()) {
            log.info("openFixedDeposit() method: Validation errors - re-displaying form for opening a new fixed deposit");
            return "createFixedDepositForm";
        } else {
            fixedDepositService.saveFixedDeposit(fixedDepositDetails);
            sessionStatus.setComplete();
            log.info("openFixedDeposit() method: Fixed deposit details successfully saved. Redirecting to show the list of fixed deposits.");
            return "redirect:/fixedDeposit/list";
        }
    }

    @RequestMapping(params = "fdAction=edit", method = RequestMethod.POST)
    public String editFixedDeposit(
            @Valid @ModelAttribute("editableFixedDepositDetails") FixedDepositDetails fixedDepositDetails,
            BindingResult bindingResult, SessionStatus sessionStatus) {
        System.out.println("error " + bindingResult.getAllErrors());
//        new FixedDepositDetailsValidator().validate(fixedDepositDetails, bindingResult);

        if (bindingResult.hasErrors()) {
            log.info("editFixedDeposit() method: Validation errors - re-displaying form for editing a fixed deposit");
            return "editFixedDepositForm";
        } else {
            fixedDepositService.editFixedDeposit(fixedDepositDetails);
            sessionStatus.setComplete();
            log.info("editFixedDeposit() method: Fixed deposit details successfully changed. Redirecting to show the list of fixed deposits.");
            return "redirect:/fixedDeposit/list";
        }
    }

    @RequestMapping(params = "fdAction=close", method = RequestMethod.GET)
    public String closeFixedDeposit(
            @RequestParam(value = "fixedDepositId") int fdId) {
        fixedDepositService.closeFixedDeposit(fdId);
        log.info("closeFixedDeposit() method: Fixed deposit successfully closed. Redirecting to show the list of fixed deposits.");
        return "redirect:/fixedDeposit/list";
    }

    @RequestMapping(params = "fdAction=view", method = RequestMethod.GET)
    public ModelAndView viewFixedDepositDetails(
            @RequestParam(value = "fixedDepositId") int fixedDepositId) {
        FixedDepositDetails fixedDepositDetails = fixedDepositService
                .getFixedDeposit(fixedDepositId);
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("editableFixedDepositDetails", fixedDepositDetails);
        log.info("viewFixedDepositDetails() method: Fixed deposit details loaded from data store. Showing form for editing the loaded fixed deposit.");
        return new ModelAndView("editFixedDepositForm", modelMap);
    }

    @InitBinder(value = "newFixedDepositDetails")
    public void initBinder_New(WebDataBinder webDataBinder) {
        log.info("initBinder_New() method: Registering CustomDateEditor");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("MM-dd-yyyy"), false));
        webDataBinder.setValidator(new FixedDepositDetailsValidator());
    }

    @InitBinder(value = "editableFixedDepositDetails")
    public void initBinder_Edit(WebDataBinder webDataBinder) {
        log.info("initBinder_Edit() method: Registering CustomDateEditor");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("MM-dd-yyyy"), false));
        webDataBinder.setDisallowedFields("id");
    }
}
