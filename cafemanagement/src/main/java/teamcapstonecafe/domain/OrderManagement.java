package teamcapstonecafe.domain;

import teamcapstonecafe.domain.CoffeeDone;
import teamcapstonecafe.CafemanagementApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="OrderManagement_table")
@Data

public class OrderManagement  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String productId;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private Long orderId;

    @PostPersist
    public void onPostPersist(){


        CoffeeDone coffeeDone = new CoffeeDone(this);
        coffeeDone.publishAfterCommit();

    }

    public static OrderManagementRepository repository(){
        OrderManagementRepository orderManagementRepository = CafemanagementApplication.applicationContext.getBean(OrderManagementRepository.class);
        return orderManagementRepository;
    }

    public void OrderConfirmed(){
        //
    }



    public static void orderReceived(PaymentApproved paymentApproved){

        /** Example 1:  new item 
        OrderManagement orderManagement = new OrderManagement();
        repository().save(orderManagement);

        */

        /** Example 2:  finding and process
        
        repository().findById(paymentApproved.get???()).ifPresent(orderManagement->{
            
            orderManagement // do something
            repository().save(orderManagement);


         });
        */

        
    }


}
