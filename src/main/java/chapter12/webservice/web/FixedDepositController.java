package chapter12.webservice.web;

import chapter12.webservice.domain.FixedDepositDetails;
import chapter12.webservice.exception.ValidationException;
import chapter12.webservice.service.FixedDepositService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Controller
@RequestMapping("/fixedDeposits")
@Log4j
public class FixedDepositController {
    private static final String LIST_METHOD = "getFixedDepositList";
    private static final String GET_FD_METHOD = "getFixedDeposit";
    private static final String OPEN_FD_METHOD = "openFixedDeposit";
    private static final String EDIT_FD_METHOD = "editFixedDeposit";
    private static final String CLOSE_FD_METHOD = "closeFixedDeposit";

    @SuppressWarnings("rawtypes")
    private final Queue<ResultContext> deferredResultQueue = new ConcurrentLinkedQueue<>();

    @Autowired
    private FixedDepositService fixedDepositService;

    @RequestMapping(method = RequestMethod.GET)
    public DeferredResult<ResponseEntity<List<FixedDepositDetails>>> getFixedDepositList() {
        log.info("getFixedDepositList() method: Getting list of fixed deposits");

        DeferredResult<ResponseEntity<List<FixedDepositDetails>>> dr = new DeferredResult<>();

        ResultContext<ResponseEntity<List<FixedDepositDetails>>> resultContext = new ResultContext();
        resultContext.setDeferredResult(dr);
        resultContext.setMethodToInvoke(LIST_METHOD);
        resultContext.setArgs(new HashMap<String, Object>());

        deferredResultQueue.add(resultContext);
        return dr;
    }

    @RequestMapping(value = "/{fixedDepositId}", method = RequestMethod.GET)
    public ResponseEntity<FixedDepositDetails> getFixedDeposit(
            @PathVariable("fixedDepositId") int id) {
        log.info("getFixedDeposit() method: Getting fixed deposit with id " + id);
        return new ResponseEntity<>(fixedDepositService.getFixedDeposit(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public DeferredResult<ResponseEntity<FixedDepositDetails>> openFixedDeposit(
            @RequestBody FixedDepositDetails fixedDepositDetails,
            BindingResult bindingResult) {

        DeferredResult<ResponseEntity<FixedDepositDetails>> dr = new DeferredResult<>();

        ResultContext<ResponseEntity<FixedDepositDetails>> resultContext = new ResultContext<>();
        resultContext.setDeferredResult(dr);
        resultContext.setMethodToInvoke(OPEN_FD_METHOD);
        Map<String, Object> args = new HashMap<>();
        args.put("fixedDepositDetails", fixedDepositDetails);
        args.put("bindingResult", bindingResult);
        resultContext.setArgs(args);

        deferredResultQueue.add(resultContext);
        return dr;
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

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Scheduled(fixedRate = 10000)
    public void processResults() {
        for (ResultContext resultContext : deferredResultQueue) {
            if (resultContext.getMethodToInvoke() == LIST_METHOD) {
                resultContext.getDeferredResult().setResult(
                        new ResponseEntity<List<FixedDepositDetails>>(
                                fixedDepositService.getFixedDeposits(), HttpStatus.OK));
            }

            if (resultContext.getMethodToInvoke() == OPEN_FD_METHOD) {
                FixedDepositDetails fixedDepositDetails = (FixedDepositDetails) resultContext
                        .getArgs().get("fixedDepositDetails");
                BindingResult bindingResult = (BindingResult) resultContext
                        .getArgs().get("bindingResult");

                new FixedDepositValidator().validate(fixedDepositDetails, bindingResult);

                if (bindingResult.hasErrors()) {
                    log.info("openFixedDeposit() method: Validation errors occurred");
                    resultContext.getDeferredResult().setErrorResult(
                            new ValidationException("Validation errors occurred"));
                } else {
                    fixedDepositService.saveFixedDeposit(fixedDepositDetails);
                    resultContext.getDeferredResult().setResult(
                            new ResponseEntity<FixedDepositDetails>(
                                    fixedDepositDetails, HttpStatus.CREATED));
                    log.info("openFixedDeposit() method: Fixed deposit details successfully saved.");
                }
            }
            // ...
            deferredResultQueue.remove(resultContext);
        }
    }
}
