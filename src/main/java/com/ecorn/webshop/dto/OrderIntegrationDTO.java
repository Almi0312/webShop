package com.ecorn.webshop.dto;

import com.ecorn.webshop.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderIntegrationDTO {
    private Long orderId;
    private String username;
    private String address;
    private List<OrderDetailsDTO> details;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderDetailsDTO {
        private String product;
        private BigDecimal price;
        private Long amount;
        private BigDecimal sum;

        public OrderDetailsDTO(OrderDetails details) {
            this.price = details.getPrice();
            this.amount =  details.getAmount();
            this.sum = details.getPrice().multiply(new BigDecimal(details.getAmount()));
        }
    }
}
