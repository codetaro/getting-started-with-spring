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
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log4j
public class FixedDepositWSClient {
    private static ApplicationContext context;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter12/webservice_client/applicationContext.xml");
        getFixedDepositList(context.getBean(RestTemplate.class));
        getFixedDeposit(context.getBean(RestTemplate.class));
        openFixedDeposit(context.getBean(RestTemplate.class));
        editFixedDeposit(context.getBean(RestTemplate.class));
        closeFixedDeposit(context.getBean(RestTemplate.class));
        try {
            openInvalidFixedDeposit(context.getBean(RestTemplate.class));
        } catch (Exception e) {
            log.error("Error occurred when the fixed deposit amount was 100");
        }
    }

    private static void getFixedDepositList(RestTemplate restTemplate) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ParameterizedTypeReference<List<FixedDepositDetails>> typeRef =
                new ParameterizedTypeReference<List<FixedDepositDetails>>() {};

        ResponseEntity<List<FixedDepositDetails>> responseEntity = restTemplate
                .exchange(
                        "http://localhost:8080/ch12-webservice/fixedDeposits",
                        HttpMethod.GET, requestEntity, typeRef);
        List<FixedDepositDetails> fixedDepositDetails = responseEntity.getBody();
        log.info("List of fixed deposit details: \n" + fixedDepositDetails);
    }

    private static void getFixedDeposit(RestTemplate restTemplate) {
        ResponseEntity<FixedDepositDetails> responseEntity = restTemplate
                .getForEntity(
                        "http://localhost:8080/ch12-webservice/fixedDeposits?id=1",
                        FixedDepositDetails.class);
        FixedDepositDetails fixedDepositDetails = responseEntity.getBody();
        log.info("Fixed deposit details for id = 1: \n" + fixedDepositDetails);
    }

    private static void openFixedDeposit(RestTemplate restTemplate) {
        FixedDepositDetails fdd = new FixedDepositDetails();
        fdd.setDepositAmount("9999");
        fdd.setEmail("99@somedomain.com");
        fdd.setTenure("12");

        ResponseEntity<FixedDepositDetails> responseEntity = restTemplate
                .postForEntity(
                        "http://localhost:8080/ch12-webservice/fixedDeposits",
                        fdd, FixedDepositDetails.class);

        FixedDepositDetails fixedDepositDetails = responseEntity.getBody();
        log.info("Details of the newly created fixed deposit: " + fixedDepositDetails);
    }

    private static void openInvalidFixedDeposit(RestTemplate restTemplate) {
        FixedDepositDetails fdd = new FixedDepositDetails();
        fdd.setDepositAmount("100");
        fdd.setEmail("99@somedomain.com");
        fdd.setTenure("12");

        ResponseEntity<FixedDepositDetails> responseEntity = restTemplate
                .postForEntity(
                        "http://localhost:8080/ch12-webservice/fixedDeposits",
                        fdd, FixedDepositDetails.class);

        FixedDepositDetails fixedDepositDetails = responseEntity.getBody();
        log.info("Details of the newly created fixed deposit: " + fixedDepositDetails);
    }

    private static void editFixedDeposit(RestTemplate restTemplate) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");

        FixedDepositDetails fdd = new FixedDepositDetails();
        fdd.setDepositAmount("9999");
        fdd.setEmail("99@somedomain.com");
        fdd.setTenure("12");

        HttpEntity<FixedDepositDetails> requestEntity = new HttpEntity<>(fdd, headers);

        ResponseEntity<FixedDepositDetails> responseEntity = restTemplate
                .exchange(
                        "http://localhost:8080/ch12-webservice/fixedDeposits?id=2",
                        HttpMethod.PUT, requestEntity,
                        FixedDepositDetails.class);
        FixedDepositDetails fixedDepositDetails = responseEntity.getBody();
        log.info("Modified fixed deposit details: " + fixedDepositDetails);
    }

    private static void closeFixedDeposit(RestTemplate restTemplate) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "text/plain");

        HttpEntity<FixedDepositDetails> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://localhost:8080/ch12-webservice/fixedDeposits?id=3",
                HttpMethod.DELETE, requestEntity, String.class);
        log.info("HTTP status code: " + responseEntity.getStatusCode()
                + ". Response body: " + responseEntity.getBody());
    }
}
