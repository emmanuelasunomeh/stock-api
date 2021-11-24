package com.active.edge.stock.api.activeedge.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "STOCK")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_sequence")
    @SequenceGenerator(name = "stock_sequence", sequenceName = "stock_sequence", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="CURRENT_PRICE")
    private Double current_price;

    @Column(name="CREATE_DATE")
    private LocalDateTime create_date;

    @Column(name="LAST_UPDATE")
    private LocalDateTime last_update;

}
