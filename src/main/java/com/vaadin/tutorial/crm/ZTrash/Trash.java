package com.vaadin.tutorial.crm.ZTrash;
/*
package com.vaadin.tutorial.crm.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "account",
        "amount",
        "currency"
})
public class PaymentModel {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("account")
    private String account;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("currency")
    private String currency;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("account")
    public String getAccount() {
        return account;
    }

    @JsonProperty("account")
    public void setAccount(String account) {
        this.account = account;
    }

    @JsonProperty("amount")
    public Double getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "PaymentModel{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}



 */

public class Trash {


}
//Klasa payment client

/*    private RestTemplate restTemplate;

    @Autowired
    private RestTemplate restTemplate;

    public List<Payments> getPaymentsList() {

        try {
            Payments[] boardsResponse = restTemplate.getForObject("https://thawing-cliffs-43759.herokuapp.com/v1/payment/getPayments", Payments[].class);
            return Arrays.asList(ofNullable(boardsResponse).orElse(new Payments[0]));
        }catch (RestClientException e) {

            return new ArrayList<>();
        }
    }
*/

//private RestTemplate restTemplate;

/*
    @EventListener(ApplicationReadyEvent.class)
    public List<Payments> getPaymentsList(){
    RestTemplate restTemplate=new RestTemplate();

        Payments[] exchange = restTemplate.getForObject(
                "https://thawing-cliffs-43759.herokuapp.com/v1/payment/getPayments",
                Payments[].class);

        System.out.println(exchange);
        System.out.println(exchange.length);

        //String json = new Gson().toJson(exchange);
//return null;
        return new ArrayList<>();
    }
*/