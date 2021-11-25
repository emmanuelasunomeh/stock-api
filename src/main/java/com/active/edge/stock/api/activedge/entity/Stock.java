package com.active.edge.stock.api.activedge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "STOCK")
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name="CREATE_DATE", nullable = false, updatable = false)
    private Date create_date;

    @Column(name="LAST_UPDATE")
    private Date last_update;

    @PrePersist
    protected void prePersist() {
        if (this.create_date == null) create_date = new Date();
        if (this.last_update == null) last_update = new Date();
    }

    @PreUpdate
    protected void preUpdate() {
        this.last_update = new Date();
    }

}
