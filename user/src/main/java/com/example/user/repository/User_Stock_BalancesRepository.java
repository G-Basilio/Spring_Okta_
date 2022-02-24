package com.example.user.repository;



import com.example.user.model.User_Stock_Balances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface User_Stock_BalancesRepository extends JpaRepository<User_Stock_Balances, Long> { //usar por que ja tem varios metodos como save, delete etc... {
    
    @Query(value = "SELECT * FROM user_stock_balances WHERE id_user = ?1 and id_stock = ?2", nativeQuery = true)
    User_Stock_Balances findByUserAndStock(long id_user, long id_stock);

    /* @Query(value = "SELECT * FROM user_stock_balances WHERE id_user = ?1", nativeQuery = true)
    User_Stock_Balances finByUser(long id_user);

    @Query(value = "SELECT usb.* FROM user_stock_balances usb inner join users u on u.id = usb.id_user where u.username = :email order by volume desc", nativeQuery = true)
    List<User_Stock_Balances[]> finByEmail(long id_user, long id_stock, long volume);

    @Modifying
    @Transactional
    @Query(value = "update user_stock_balances set volume = ?3 where id_user = ?1 and id_stock = ?2", nativeQuery = true)
    void updateBalances(long id_user, long id_stock, long volume); */
}
