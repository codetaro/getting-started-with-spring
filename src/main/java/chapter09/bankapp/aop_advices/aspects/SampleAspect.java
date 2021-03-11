package chapter09.bankapp.aop_advices.aspects;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Log4j
public class SampleAspect {

    @Pointcut(value = "execution(* chapter09.bankapp.aop_advices..BankAccountService.createBankAccount(..))")
    private void createBankAccountMethod() {}

    @Pointcut(value = "execution(* chapter09.bankapp.aop_advices..FixedDepositService.*(..))")
    private void exceptionMethods() {}

    @AfterReturning(value = "createBankAccountMethod()", returning = "aValue")
    public void afterReturningAdvice(JoinPoint joinPoint, int aValue) {
        log.info("Value returned by " + joinPoint.getSignature().getName()
                + " method is " + aValue);
    }

    @AfterThrowing(value = "exceptionMethods()", throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        log.info("Exception thrown by " + joinPoint.getSignature().getName()
                + " Exception type is " + exception);
    }

    @After(value = "exceptionMethods() || createBankAccountMethod()")
    public void afterAdvice(JoinPoint joinPoint) {
        log.info("After advice executed for "
                + joinPoint.getSignature().getName());
    }

    @Around(value = "execution(* chapter09.bankapp.aop_advices..*Service.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        Object obj = null;
        StopWatch watch = new StopWatch();
        watch.start();
        try {
            obj = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        watch.stop();
        log.info(watch.prettyPrint());
        return obj;
    }
}
