package teamcapstonecafe.domain;

import teamcapstonecafe.domain.*;
import teamcapstonecafe.infra.AbstractEvent;
import lombok.*;
import java.util.*;
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
}


