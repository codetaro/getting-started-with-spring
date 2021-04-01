package chapter12.webservice.web;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;

public class ResultContext<T> {
    @Getter @Setter private String methodToInvoke;
    @Getter @Setter private DeferredResult<T> deferredResult;
    @Getter @Setter private Map<String, Object> args;

}
