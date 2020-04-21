package com.vaadin.tutorial.crm.client;

import com.vaadin.tutorial.crm.model.payment.CreatedNewPayment;
import com.vaadin.tutorial.crm.model.payment.NewPayment;
import com.vaadin.tutorial.crm.model.payment.Payments;
import com.vaadin.tutorial.crm.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component

public class PaymentClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PaymentService paymentService;

    //TODO skrocic link
    public List<Payments> getPaymentsList() {
        URI url = UriComponentsBuilder.fromHttpUrl("https://thawing-cliffs-43759.herokuapp.com/v1/payment/getPayments")
                .queryParam("fields", "id").build().encode().toUri();

        Payments[] boardsResponse = restTemplate.getForObject(url, Payments[].class);
        if (boardsResponse != null) {
            return Arrays.asList(boardsResponse);
        }
        return new ArrayList<>();
    }

    public CreatedNewPayment createNewPayment(NewPayment newPayment){
        //TODO skrocic link
        URI url = UriComponentsBuilder.fromHttpUrl("https://thawing-cliffs-43759.herokuapp.com/v1/payment/createPayment")
                .queryParam("account",newPayment.getAccount())
                .queryParam("amount",newPayment.getAmount())
                .queryParam("currency",newPayment.getCurrency()).build().encode().toUri();

        return restTemplate.postForObject(url,newPayment, CreatedNewPayment.class);

    }
/*
    public void deletePayment(Long id){
      //  URI url = UriComponentsBuilder.fromHttpUrl("https://thawing-cliffs-43759.herokuapp.com/v1/payment/deletePayment")
        //        .queryParam("fields", "id").build().encode().toUri();
        String entityUrl="https://thawing-cliffs-43759.herokuapp.com/v1/payment/deletePayment/{id}";
        restTemplate.delete(entityUrl);
    }
*/
public void deletePayment(Long paymentId) {
    URI url = UriComponentsBuilder.fromHttpUrl("https://thawing-cliffs-43759.herokuapp.com/v1/payment/deletePayment + paymentId")
            .build().encode().toUri();
        restTemplate.delete(url);

}

    /*
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {
        service.deleteProduct(productId);
    }
     */
}
