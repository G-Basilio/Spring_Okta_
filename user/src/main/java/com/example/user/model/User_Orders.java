package com.example.user.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
@Table(name = "user_orders")
public class User_Orders  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="id_user")
    private User id_user;
    private Long id_stock;
    private String stock_symbol;
    private String stock_name;
    private Integer volume;
    private Integer volume_remaining;
    private BigDecimal price;
    private Integer type;
    private Integer status;
    @UpdateTimestamp
    @Column(name = "created_on")
    private Timestamp created_on;
    @UpdateTimestamp
    @Column(name = "updated_on")
    private Timestamp updatedOn;
    

    public User_Orders() {
    }

    public User_Orders(User id_user,Long id, Long id_stock, String stock_symbol, String stock_name,
            BigDecimal price, Integer type, Integer status, Integer volume, Integer volume_remaining) {
                this.id_user = id_user;
                this.id = id;
                this.id_stock = id_stock;
                this.stock_symbol = stock_symbol;
                this.stock_name = stock_name;
                this.price = price;
                this.type = type;
                this.status = status;
                this.volume_remaining = volume_remaining;
                this.volume = volume;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User_Orders user_Orders = (User_Orders) o;
        return id == user_Orders.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

