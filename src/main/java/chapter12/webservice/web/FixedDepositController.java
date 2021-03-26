package chapter12.webservice.web;

import chapter12.webservice.domain.FixedDepositDetails;
import chapter12.webservice.exception.ValidationException;
import chapter12.webservice.service.FixedDepositService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fixedDeposits")
@Log4j
public class FixedDepositController {

    @Autowired
    private FixedDepositService fixedDepositService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<FixedDepositDetails>> getFixedDepositList() {
        log.info("getFixedDepositList() method: Getting list of fixed deposits");
        return new ResponseEntity<>(fixedDepositService.getFixedDeposits(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{fixedDepositId}", method = RequestMethod.GET)
    public ResponseEntity<FixedDepositDetails> getFixedDeposit(
            @PathVariable("fixedDepositId") int id) {
        log.info("getFixedDeposit() method: Getting fixed deposit with id " + id);
        return new ResponseEntity<>(fixedDepositService.getFixedDeposit(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<FixedDepositDetails> openFixedDeposit(
            @RequestBody FixedDepositDetails fixedDepositDetails,
            BindingResult bindingResult) {

        new FixedDepositValidator().validate(fixedDepositDetails, bindingResult);

        if (bindingResult.hasErrors()) {
            log.info("openFixedDeposit() method: Validation errors occurred");
            throw new ValidationException("Validation errors occurred");
        } else {
            fixedDepositService.saveFixedDeposit(fixedDepositDetails);
            log.info("openFixedDeposit() method: Fixed deposit details successfully saved.");
            return new ResponseEntity<>(fixedDepositDetails, HttpStatus.CREATED);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<FixedDepositDetails> editFixedDeposit(
            @RequestBody FixedDepositDetails fixedDepositDetails,
            @RequestParam("id") int fixedDepositId, BindingResult bindingResult) {

        fixedDepositDetails.setId(fixedDepositId);
        new FixedDepositValidator().validate(fixedDepositDetails, bindingResult);

        if (bindingResult.hasErrors()) {
            log.info("editFixedDeposit() method: Validation errors occurred");
            throw new ValidationException("Validation errors occurred");
        } else {
            fixedDepositService.editFixedDeposit(fixedDepositDetails);
            log.info("editFixedDeposit() method: Fixed deposit details successfully changed.");
            return new ResponseEntity<>(fixedDepositDetails, HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public HttpEntity<String> closeFixedDeposit(@RequestParam(value = "id") int fdId) {
        fixedDepositService.closeFixedDeposit(fdId);
        log.info("closeFixedDeposit() method: Fixed deposit successfully closed.");
        return new HttpEntity<>("Successfully deleted the fixed deposit");
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleException(Exception ex) {
        log.info("handling ValidationException " + ex.getMessage());
        return ex.getMessage();
    }
}
