package chapter09.bankapp.aop_pointcuts.aspects;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j
public class LoggingAspect {

    @Pointcut(value = "execution(* chapter09.bankapp.aop_pointcuts.service.*Service.*(..))")
    private void invokeServiceMethods() {}

    @Before(value = "invokeServiceMethods()")
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
