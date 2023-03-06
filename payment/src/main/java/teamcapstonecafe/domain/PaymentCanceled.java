package teamcapstonecafe.domain;

import teamcapstonecafe.domain.*;
import teamcapstonecafe.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class PaymentCanceled extends AbstractEvent {

    private Long id;
    private Float amount;
    private String status;
    private String customerId;
    private Long orderId;
    private Integer qty;
    private String productId;

    public PaymentCanceled(Pay aggregate){
        super(aggregate);
    }
    public PaymentCanceled(){
        super();
    }
}
