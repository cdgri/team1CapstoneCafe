package teamcapstonecafe.domain;

import teamcapstonecafe.domain.*;
import teamcapstonecafe.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CoffeeDone extends AbstractEvent {

    private Long id;
    private String customerId;
    private Integer point;
    private String productId;
    private Integer qty;
    private String status;
    private Long orderId;

    public CoffeeDone(OrderManagement aggregate){
        super(aggregate);
    }
    public CoffeeDone(){
        super();
    }
}
