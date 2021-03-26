package chapter12.webservice_client;

import chapter12.webservice_client.domain.FixedDepositDetails;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Log4j
public class FixedDepositWSAsyncClient {
    private static ApplicationContext context;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext(
                "META-INF/spring/chapter12/webservice_client/applicationContext.xml");
        try {
            getFixedDepositList(context.getBean(AsyncRestTemplate.class));
            openFixedDeposit(context.getBean(AsyncRestTemplate.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getFixedDepositList(AsyncRestTemplate restTemplate)
            throws InterruptedException, ExecutionException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ParameterizedTypeReference<List<FixedDepositDetails>> typeRef =
                new ParameterizedTypeReference<List<FixedDepositDetails>>() {
                };

        ListenableFuture<ResponseEntity<List<FixedDepositDetails>>> futureResponseEntity = restTemplate
                .exchange(
                        "http://localhost:8080/ch12-webservice/fixedDeposits",
                        HttpMethod.GET, requestEntity, typeRef);
        futureResponseEntity
                .addCallback(new ListenableFutureCallback<ResponseEntity<List<FixedDepositDetails>>>() {
                    @Override
                    public void onSuccess(ResponseEntity<List<FixedDepositDetails>> result) {
                        List<FixedDepositDetails> fixedDepositDetails = result.getBody();
                        log.info("List of fixed deposit details: \n" + fixedDepositDetails);
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
    }

    private static void openFixedDeposit(AsyncRestTemplate restTemplate) {
        FixedDepositDetails fdd = new FixedDepositDetails();
        fdd.setDepositAmount("9999");
        fdd.setEmail("99@somedomain.com");
        fdd.setTenure("12");

        HttpEntity<FixedDepositDetails> requestEntity = new HttpEntity<>(fdd);

        ListenableFuture<ResponseEntity<FixedDepositDetails>> futureResponseEntity =
                restTemplate.postForEntity(
                        "http://localhost:8080/ch12-webservice/fixedDeposits",
                        requestEntity, FixedDepositDetails.class);

        futureResponseEntity
                .addCallback(new ListenableFutureCallback<ResponseEntity<FixedDepositDetails>>() {
                    @Override
                    public void onSuccess(ResponseEntity<FixedDepositDetails> entity) {
                        FixedDepositDetails fixedDepositDetails = entity.getBody();
                        log.info("Details of the newly created fixed deposit: "
                                + fixedDepositDetails);
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
    }
}
