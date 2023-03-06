package teamcapstonecafe.domain;

import teamcapstonecafe.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class Ordered extends AbstractEvent {

    private Long id;
    private Integer qty;
    private String customerId;
    private Float amount;
    private String status;
    private String productId;
    private Long orderId;
}
