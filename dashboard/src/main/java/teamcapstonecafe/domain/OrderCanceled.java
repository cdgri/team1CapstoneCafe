package teamcapstonecafe.domain;

import teamcapstonecafe.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private String productId;
    private Integer qty;
    private Float amount;
    private String status;
    private String customerId;
    private Long orderId;
}
