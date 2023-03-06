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

        /** Example 1:  new item 
        PushMessage pushMessage = new PushMessage();
        repository().save(pushMessage);

        */

        /** Example 2:  finding and process
        
        repository().findById(coffeeDone.get???()).ifPresent(pushMessage->{
            
            pushMessage // do something
            repository().save(pushMessage);


         });
        */

        
    }
    public static void messageNotified(Ordered ordered){

        /** Example 1:  new item 
        PushMessage pushMessage = new PushMessage();
        repository().save(pushMessage);

        */

        /** Example 2:  finding and process
        
        repository().findById(ordered.get???()).ifPresent(pushMessage->{
            
            pushMessage // do something
            repository().save(pushMessage);


         });
        */

        
    }
    public static void messageNotified(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        PushMessage pushMessage = new PushMessage();
        repository().save(pushMessage);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(pushMessage->{
            
            pushMessage // do something
            repository().save(pushMessage);


         });
        */

        
    }
    public static void messageNotified(PaymentCanceled paymentCanceled){

        /** Example 1:  new item 
        PushMessage pushMessage = new PushMessage();
        repository().save(pushMessage);

        */

        /** Example 2:  finding and process
        
        repository().findById(paymentCanceled.get???()).ifPresent(pushMessage->{
            
            pushMessage // do something
            repository().save(pushMessage);


         });
        */

        
    }
    public static void messageNotified(PaymentApproved paymentApproved){

        /** Example 1:  new item 
        PushMessage pushMessage = new PushMessage();
        repository().save(pushMessage);

        */

        /** Example 2:  finding and process
        
        repository().findById(paymentApproved.get???()).ifPresent(pushMessage->{
            
            pushMessage // do something
            repository().save(pushMessage);


         });
        */

        
    }


}
