package com.example.fast.model.entity;

import com.example.fast.model.enumclass.OrderType;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"user", "orderGroup"})
@Builder
@Accessors(chain = true)
public class OrderGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @Enumerated(EnumType.STRING)
    private OrderType orderType; // (주문의 형태 - 일괄 / 개별)

    private String revAddress;

    private String revName;

    private String paymentType; // (카드 / 현금)

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    // N (OrderGroup) : 1 (User)
    @ManyToOne
//    private Long userId;
    private User user;

    // 1 (OrderGroup) : N (OrderDetail)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
    private List<OrderDetail> orderDetailList;
}
