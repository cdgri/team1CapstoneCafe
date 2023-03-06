package teamcapstonecafe.domain;

import teamcapstonecafe.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class PaymentApproved extends AbstractEvent {

    private Long id;
    private Float amount;
    private String status;
    private String customerId;
    private Long orderId;
    private Integer qty;
    private String productId;
}
