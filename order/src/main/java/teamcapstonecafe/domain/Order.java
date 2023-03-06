package teamcapstonecafe.domain;

import teamcapstonecafe.domain.Ordered;
import teamcapstonecafe.domain.OrderCanceled;
import teamcapstonecafe.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Order_table")
@Data

public class Order  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String productId;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private Float amount;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private Long orderId;

    @PostPersist
    public void onPostPersist(){


        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();



        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void updateOrderStatus(CoffeeDone coffeeDone){
        repository().findAll().forEach(s -> {
            if(s.orderId == coffeeDone.getOrderId()){
                s.setStatus(coffeeDone.getStatus());
            };
        });
    }
    public static void updateOrderStatus(PaymentApproved paymentApproved){
        repository().findAll().forEach(s -> {
            if(s.orderId == paymentApproved.getOrderId()){
                s.setStatus(paymentApproved.getStatus());
            };
        });
    }
    public static void updateOrderStatus(Ordered ordered){
        //DO NOT NEED
    }
    public static void updateOrderStatus(OrderCanceled orderCanceled){
        repository().findAll().forEach(s -> {
            if(s.orderId == orderCanceled.getOrderId()){
                s.setStatus(orderCanceled.getStatus());
            };
        });
    }


}
