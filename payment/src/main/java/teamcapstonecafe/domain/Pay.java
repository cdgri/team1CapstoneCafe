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
        repository().findAll().forEach(s -> {
            if(s.orderId == orderCanceled.getOrderId()){
                s.setStatus("PaymentCanceled");
            };
        });
    }
    public static void payment(Ordered ordered){
        Pay pay = new Pay();
        pay.setOrderId(ordered.getOrderId());
        pay.setCustomerId(ordered.getCustomerId());
        pay.setProductId(ordered.getProductId());
        pay.setQty(ordered.getQty());
        pay.setAmount(ordered.getAmount());
        pay.setStatus("PaymentApproved");
        repository().save(pay);
    }


}
