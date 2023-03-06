package teamcapstonecafe.domain;

import teamcapstonecafe.CustomermanagementApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="PushMessage_table")
@Data

public class PushMessage  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String sendMsg;
    
    
    
    
    
    private String productId;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private Long orderId;


    public static PushMessageRepository repository(){
        PushMessageRepository pushMessageRepository = CustomermanagementApplication.applicationContext.getBean(PushMessageRepository.class);
        return pushMessageRepository;
    }




    public static void messageNotified(CoffeeDone coffeeDone){
        repository().findAll().forEach(s -> {
            if(s.orderId == coffeeDone.getOrderId()){
                s.setStatus(coffeeDone.getStatus());
                s.setSendMsg("CoffeeDone");
            };
        });
    }
    public static void messageNotified(Ordered ordered){
        PushMessage pushMessage = new PushMessage();
        pushMessage.setOrderId(ordered.getOrderId());
        //pushMessage.setCustomerId(ordered.getCustomerId()); TODO: fix model
        //pushMessage.setAmount(ordered.getAmount()); TODO: fix model
        pushMessage.setProductId(ordered.getProductId());
        pushMessage.setQty(ordered.getQty());
        pushMessage.setStatus(ordered.getStatus());
        pushMessage.setSendMsg("Ordered");
        repository().save(pushMessage);
    }
    public static void messageNotified(OrderCanceled orderCanceled){
        repository().findAll().forEach(s -> {
            if(s.orderId == orderCanceled.getOrderId()){
                s.setStatus(orderCanceled.getStatus());
                s.setSendMsg("OrderCanceled");
            };
        });
    }
    public static void messageNotified(PaymentCanceled paymentCanceled){
        repository().findAll().forEach(s -> {
            if(s.orderId == paymentCanceled.getOrderId()){
                s.setStatus(paymentCanceled.getStatus());
                s.setSendMsg("PaymentCanceled");
            };
        });
    }
    public static void messageNotified(PaymentApproved paymentApproved){
        repository().findAll().forEach(s -> {
            if(s.orderId == paymentApproved.getOrderId()){
                s.setStatus(paymentApproved.getStatus());
                s.setSendMsg("PaymentApproved");
            };
        });
    }


}
