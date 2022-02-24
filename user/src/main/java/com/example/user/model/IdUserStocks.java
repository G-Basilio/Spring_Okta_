package com.example.user.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;



@Data
@Embeddable
public class IdUserStocks implements Serializable {
    @ManyToOne
    @JoinColumn(name="id_user")
    private User user ;
    private Long id_stock;
    


    public IdUserStocks(User user, Long id_stock) {
        this.user = user;
        this.id_stock = id_stock;
    }
    public IdUserStocks() {
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IdUserStocks other = (IdUserStocks) obj;
        if (id_stock == null) {
            if (other.id_stock != null)
                return false;
        } else if (!id_stock.equals(other.id_stock))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_stock == null) ? 0 : id_stock.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }
/*     @Override
    public int hashCode() {
        return Objects.hash(user, id_stock);
    }
    
     @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj Instanceof IdUserStocks))
            return false;
        IdUserStocks idUserStocks = (IdUserStocks) obj;
        return user.equals(idUserStocks.user) && id_stock.equals(idUserStocks.id_stock);
    }  */
    
}
