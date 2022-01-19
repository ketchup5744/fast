package com.example.fast.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // order_detail
@ToString(exclude = {"user", "item"})
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderAt;

    // N : 1
    @ManyToOne
//    private Long userId;
    private User user;

    // N : 1
    @ManyToOne
//    private Long itemId;
    private Item item;

}
