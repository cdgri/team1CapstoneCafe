package teamcapstonecafe.domain;

import teamcapstonecafe.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class CoffeeDone extends AbstractEvent {

    private Long id;
    private String customerId;
    private Integer point;
    private String productId;
    private Integer qty;
    private String status;
    private Long orderId;
}
