package chapter09.bankapp.simple_aop.aspects;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j
public class LoggingAspect {

    @Before(value = "execution(* chapter09.bankapp.simple_aop.service.*Service.*(..))")
    public void log(JoinPoint joinPoint) {
        log.info("Entering "
                + joinPoint.getTarget().getClass().getSimpleName() + "'s "
                + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            log.info("args[" + i + "] --> " + args[i]);
        }
    }
}
