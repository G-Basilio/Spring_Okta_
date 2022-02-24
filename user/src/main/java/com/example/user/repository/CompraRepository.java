package com.example.user.repository;

import javax.transaction.Transactional;
import com.example.user.model.User;
import com.example.user.model.User_Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Transactional
@Repository
public interface CompraRepository extends JpaRepository<User_Orders, Long> {
        /*
         * @Modifying
         * 
         * @Query(value = "INSERT INTO public.user_orders" +
         * "(id_user, id_stock, stock_symbol, stock_name, volume, price, type, status, created_on, updated_on)"
         * +
         * "VALUES(?1, ?2, 'BEEF', 'MINERVA', ?3, ?4, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)"
         * , nativeQuery = true)
         * int insert(Long id_user, Long id_stock, Integer volume, BigDecimal price);
         */

        // Compra 1
        // Venda 2
        @Query(value = "select * from user_orders a, user_orders b where a.type <> b.type and a.type = 1 and b.type = 2 and a.id_stock = b.id_stock and a.id <> b.id and a.status = 1", nativeQuery = true)
        List<User_Orders> matchCompra();
        
        @Modifying
        @Query(value = "update users set dollar_balance = dollar_balance - ( select uo.volume  * a.price FROM user_orders a, user_orders uo "
                        +
                        " inner join users u on uo.id_user = u.id " +
                        " where a.status = 1 and a.type = 1 and a.status = uo.status  and a.id_user = ?1 and a.id_user <> uo.id_user and a.id = ?2 fetch first 1 rows only ) where id = ?1", nativeQuery = true)
        int atualizaDollarBalanceCompra(User user, User_Orders id); //1

        @Modifying
        @Query(value = " update user_orders  set volume = (select a.volume - uo.volume from " +
                        " user_orders a, user_orders uo inner join users u on uo.id_user = u.id " +
                        " where a.type = 1 and a.id_stock = uo.id_stock  and uo.id = ?1 and uo.id_user = ?2 order by a.created_on asc fetch first 1 rows only) where id=?1 and type = 1", nativeQuery = true)
        int volumeCompra(User_Orders id, User user); //2

        @Modifying
        @Query(value = "update user_stock_balances set volume = volume + (select a.volume + uo.volume " +
                        " AS ID FROM user_orders a, user_orders uo " +
                        " inner join users u on uo.id_user = u.id " +
                        " inner join user_stock_balances usb on u.id = usb.id_user " +
                        " WHERE a.type <> uo.type  and a.id_stock = uo.id_stock and a.id= ?1 fetch first 1 rows only ) where id_user = ?2 and id_stock = ?3", nativeQuery = true)
        int atualizaVolumeStockBalanceCompra(Long id, User id_user, Long id_stock); //3


        @Modifying
        @Query(value = "UPDATE user_orders SET status = 2 WHERE volume <= 0", nativeQuery = true)
        int atualizaStatusCompra(); //4

}