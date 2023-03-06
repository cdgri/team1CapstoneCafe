package teamcapstonecafe.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import teamcapstonecafe.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import teamcapstonecafe.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired OrderRepository orderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CoffeeDone'")
    public void wheneverCoffeeDone_UpdateOrderStatus(@Payload CoffeeDone coffeeDone){

        CoffeeDone event = coffeeDone;
        System.out.println("\n\n##### listener UpdateOrderStatus : " + coffeeDone + "\n\n");


        

        // Sample Logic //
        Order.updateOrderStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PaymentApproved'")
    public void wheneverPaymentApproved_UpdateOrderStatus(@Payload PaymentApproved paymentApproved){

        PaymentApproved event = paymentApproved;
        System.out.println("\n\n##### listener UpdateOrderStatus : " + paymentApproved + "\n\n");


        

        // Sample Logic //
        Order.updateOrderStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Ordered'")
    public void wheneverOrdered_UpdateOrderStatus(@Payload Ordered ordered){

        Ordered event = ordered;
        System.out.println("\n\n##### listener UpdateOrderStatus : " + ordered + "\n\n");


        

        // Sample Logic //
        Order.updateOrderStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCanceled'")
    public void wheneverOrderCanceled_UpdateOrderStatus(@Payload OrderCanceled orderCanceled){

        OrderCanceled event = orderCanceled;
        System.out.println("\n\n##### listener UpdateOrderStatus : " + orderCanceled + "\n\n");


        

        // Sample Logic //
        Order.updateOrderStatus(event);
        

        

    }

}


