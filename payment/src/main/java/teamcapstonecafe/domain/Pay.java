package teamcapstonecafe.domain;

import teamcapstonecafe.domain.PaymentApproved;
import teamcapstonecafe.domain.PaymentCanceled;
import teamcapstonecafe.PaymentApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Pay_table")
@Data

public class Pay  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Float amount;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private String productId;

    @PostPersist
    public void onPostPersist(){


        PaymentApproved paymentApproved = new PaymentApproved(this);
        paymentApproved.publishAfterCommit();



        PaymentCanceled paymentCanceled = new PaymentCanceled(this);
        paymentCanceled.publishAfterCommit();

    }

    public static PayRepository repository(){
        PayRepository payRepository = PaymentApplication.applicationContext.getBean(PayRepository.class);
        return payRepository;
    }




    public static void cancelPayment(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        Pay pay = new Pay();
        repository().save(pay);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(pay->{
            
            pay // do something
            repository().save(pay);


         });
        */

        
    }
    public static void payment(Ordered ordered){

        /** Example 1:  new item 
        Pay pay = new Pay();
        repository().save(pay);

        */

        /** Example 2:  finding and process
        
        repository().findById(ordered.get???()).ifPresent(pay->{
            
            pay // do something
            repository().save(pay);


         });
        */

        
    }


}
