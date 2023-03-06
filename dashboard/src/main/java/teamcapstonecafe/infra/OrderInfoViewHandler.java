package teamcapstonecafe.infra;

import teamcapstonecafe.domain.*;
import teamcapstonecafe.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderInfoViewHandler {

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {

            if (!ordered.validate()) return;

            // view 객체 생성
            OrderInfo orderInfo = new OrderInfo();
            // view 객체에 이벤트의 Value 를 set 함
            orderInfo.setProductId(ordered.getProductId());
            orderInfo.setQty(ordered.getQty());
            orderInfo.setStatus(ordered.getStatus());
            orderInfo.setOrderId(ordered.getOrderId());
            // view 레파지 토리에 save
            orderInfoRepository.save(orderInfo);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_1(@Payload OrderCanceled orderCanceled) {
        try {
            if (!orderCanceled.validate()) return;
                // view 객체 조회

                List<OrderInfo> orderInfoList = orderInfoRepository.findByOrderId(orderCanceled.getOrderId());
                for(OrderInfo orderInfo : orderInfoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderInfo.setStatus(orderCanceled.getStatus());
                // view 레파지 토리에 save
                orderInfoRepository.save(orderInfo);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentApproved_then_UPDATE_2(@Payload PaymentApproved paymentApproved) {
        try {
            if (!paymentApproved.validate()) return;
                // view 객체 조회

                List<OrderInfo> orderInfoList = orderInfoRepository.findByOrderId(Long.valueOf(paymentApproved.getOrderId()));
                for(OrderInfo orderInfo : orderInfoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderInfo.setAmount(paymentApproved.getAmount());
                    orderInfo.setStatus(paymentApproved.getStatus());
                // view 레파지 토리에 save
                orderInfoRepository.save(orderInfo);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCoffeeDone_then_UPDATE_3(@Payload CoffeeDone coffeeDone) {
        try {
            if (!coffeeDone.validate()) return;
                // view 객체 조회

                List<OrderInfo> orderInfoList = orderInfoRepository.findByOrderId(Long.valueOf(coffeeDone.getOrderId()));
                for(OrderInfo orderInfo : orderInfoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderInfo.setStatus(coffeeDone.getStatus());
                // view 레파지 토리에 save
                orderInfoRepository.save(orderInfo);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

