package com.vaadin.tutorial.crm.service;

import com.vaadin.tutorial.crm.client.PaymentClient;
import com.vaadin.tutorial.crm.model.payment.CreatedNewPayment;
import com.vaadin.tutorial.crm.model.payment.NewPayment;
import com.vaadin.tutorial.crm.model.payment.Payments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentClient paymentClient;

    public PaymentService(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    public List<Payments> fetchPayments(){
        return paymentClient.getPaymentsList();
    }

    public CreatedNewPayment createdNewPayment(final NewPayment newPayment){
        CreatedNewPayment newPay =paymentClient.createNewPayment(newPayment);
        return newPay;
    }

    public void deletePayment (Payments payment) {
        paymentClient.deletePayment(payment.getId());
    }



   /* public List<Payments> deletePayment(Payments payments){
        List<Payments> list=paymentClient.getPaymentsList();
        for (Payments eachPayment : list){
            if(eachPayment.getId()==id){
                list.remove(eachPayment);
            }
        }
        return new ArrayList<>();
    }
*/
 //   public void deletePayment(Payments payments) {

//    }

    //   public void deletePayment(Long id){

   // }
}
