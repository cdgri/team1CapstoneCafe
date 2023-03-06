package teamcapstonecafe.domain;

import teamcapstonecafe.domain.*;
import teamcapstonecafe.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class PaymentApproved extends AbstractEvent {

    private Long id;
    private Float amount;
    private String status;
    private String customerId;
    private Long orderId;
    private Integer qty;
    private String productId;

    public PaymentApproved(Pay aggregate){
        super(aggregate);
    }
    public PaymentApproved(){
        super();
    }
}
