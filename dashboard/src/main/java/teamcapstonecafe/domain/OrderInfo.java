package teamcapstonecafe.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="OrderInfo_table")
@Data
public class OrderInfo {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String productId;
        private Integer qty;
        private Float amount;
        private String status;
        private Long orderId;


}
