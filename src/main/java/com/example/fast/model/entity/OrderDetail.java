package com.example.fast.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // order_detail
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"orderGroup", "item"})
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    // N (OrderDetail) : 1 (Item)
    @ManyToOne
//    private Long itemId;
    private Item item;

    // N (OrderDetail) : 1 (OrderGroup)
    @ManyToOne
//    private Long orderGroupId;
    private OrderGroup orderGroup;

    /*

    // N : 1
    @ManyToOne
//    private Long userId;
    private User user;

    // N : 1
    @ManyToOne
//    private Long itemId;
    private Item item;

    */

}
