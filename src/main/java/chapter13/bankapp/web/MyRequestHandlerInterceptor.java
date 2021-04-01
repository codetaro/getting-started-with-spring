package chapter13.bankapp.web;

import lombok.extern.log4j.Log4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Log4j
public class MyRequestHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("HTTP method --> " + request.getMethod());
        Enumeration<String> requestNames = request.getParameterNames();
        while (requestNames.hasMoreElements()) {
            String name = requestNames.nextElement();
            String value = request.getParameter(name);
            log.info("name --> " + name + ", value --> " + value);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Status code --> " + response.getStatus());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("Request processing complete");
    }
}
