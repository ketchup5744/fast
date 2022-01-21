package com.example.fast.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"orderDetailList", "partner"})
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String name;

    private String title;

    private String content;

    private Integer price;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    // N (Item) : 1 (partner)
    @ManyToOne
//    private Long partnerId;
    private Partner partner;

    // 1 (Itme) : N (OrderDetail)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;

    /*

//    // 1 (Item의 입장) : N (OrderDetail)
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
//    private List<OrderDetail> orderDetailList;

    // LAZY = 지연로딩 (필요한 데이터만 로딩), EAGER = 즉시로딩 (모든 데이터를 다 로딩, 데이터가 많을 시 느려짐)
    // LAZY = SELECT * FROM item where id = ?
    // EAGER = = item item0_ left outer join order_detail orderdetai1_ on item0_.id=orderdetai1_.item_id left outer join user user2_ on orderdetai1_.user_id=user2_.id
    // = item_id = order_detail.item_id
    // = user_id = order_detial.user_id
    // where item,id = ?
    // 연관관계 별 추천 타입
    // 1 : 1 = EAGER 타입 추천
    // 1 : N = LAZY 타입을 추천

     */

}
