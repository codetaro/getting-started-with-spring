package chapter12.webservice_client;

import lombok.extern.log4j.Log4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

@Log4j
public class MyErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        log.info("Status code received from the web service: " + response.getStatusCode());
        String body = IOUtils.toString(response.getBody());
        log.info("Response body: " + body);
        super.handleError(response);
    }
}
