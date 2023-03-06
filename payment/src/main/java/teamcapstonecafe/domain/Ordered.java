package teamcapstonecafe.domain;

import teamcapstonecafe.domain.*;
import teamcapstonecafe.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Ordered extends AbstractEvent {

    private Long id;
    private Integer qty;
    private String customerId;
    private Float amount;
    private String status;
    private String productId;
    private Long orderId;
}


