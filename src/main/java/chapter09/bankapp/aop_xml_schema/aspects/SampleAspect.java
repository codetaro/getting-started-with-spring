package chapter09.bankapp.aop_xml_schema.aspects;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

@Log4j
public class SampleAspect {

    public void afterReturningAdvice(JoinPoint joinPoint, int aValue) {
        log.info("Value returned by " + joinPoint.getSignature().getName()
                + " method is " + aValue);
    }

    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        log.info("Exception thrown by " + joinPoint.getSignature().getName()
                + " Exception type is " + exception);
    }

    public void afterAdvice(JoinPoint joinPoint) {
        log.info("After advice executed for "
                + joinPoint.getSignature().getName());
    }

    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        Object obj = null;
        StopWatch watch = new StopWatch();
        watch.start();
        try {
            obj = pjp.proceed();
        } catch (Throwable throwable) {
            // -- perform any action that you want
        }
        watch.stop();
        log.info(watch.prettyPrint());
        return obj;
    }
}
