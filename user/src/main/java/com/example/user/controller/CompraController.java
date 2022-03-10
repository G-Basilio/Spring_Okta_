package com.example.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.user.controller.DTO.User_OrdersDTO;
import com.example.user.model.User_Orders;
import com.example.user.repository.CompraRepository;

import com.example.user.repository.VendaRepository;

@RestController
public class CompraController {
    /*
     * compraRepository.insert(user_OrdersDTO.getId_user(),
     * user_OrdersDTO.getId_stock(), user_OrdersDTO.getVolume(),
     * user_OrdersDTO.getPrice());
     */
    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    VendaRepository vendaRepository;

    /* public User_OrdersDTO comprar(@RequestBody User_Orders orders) {
        User_Orders order = user_OrdersRepository.save(orders);
        User_OrdersDTO ordersDto = new User_OrdersDTO(order); */

    @PostMapping("/compra")
    public User_Orders comprar(@RequestBody User_OrdersDTO ordersDto) {
        if (ordersDto.getType() == 1) {
            List<User_Orders> userCompra = compraRepository.matchCompra();
            System.out.println("Pegou match na compra");
            List<User_Orders> userVenda = vendaRepository.matchVenda();
            System.out.println("Pegou match da venda");

            if (ordersDto != null) {
                System.out.println(ordersDto.getStatus() + "peguei o get");

                if (!userCompra.isEmpty()) {
                    System.out.println("compra positiva");
                    for (User_Orders cont : userCompra) {
                        compraRepository.atualizaDollarBalanceCompra(cont.getId_user(), cont);
                        System.out.println(cont);
                        compraRepository.volumeCompra(cont, cont.getId_user());

                        compraRepository.atualizaVolumeStockBalanceCompra(cont.getId(), cont.getId_user(), cont.getId_stock());
                    }
                    compraRepository.atualizaStatusCompra();
                }
                System.out.println("cheguei aquiii");
                if (!userVenda.isEmpty()) {
                    List<User_Orders> venda = vendaRepository.matchVenda();
                    System.out.println(venda);
                    for (User_Orders vendamatchOrders : userVenda) {
                        vendaRepository.atualizaVolumeStockBalanceVenda(vendamatchOrders.getId(), vendamatchOrders.getId_user(),
                        vendamatchOrders.getId_stock());
                        vendaRepository.atualizaDollarBalanceVenda(vendamatchOrders.getId_user(), vendamatchOrders);
                        System.out.println("chegou balance");    
                        vendaRepository.atualizaVolumeVenda(vendamatchOrders, vendamatchOrders.getId_user());
                        System.out.println("chegou pai");

                    }
                    vendaRepository.atualizaStatusVenda();
                }
            }
        }
        return null;
    }

}
/*
 * if(!userteste1.isEmpty()) {
 * System.out.println("compra negativa");
 * for (User_Orders cont:userteste1) {
 * System.out.println(user_OrdersDTO.getId());
 * compraRepository.updateDollarBalanceNE(cont, cont.getId_user());
 * compraRepository.RemainingNE(cont);
 * compraRepository.atualizarBalanceNE(cont.getId(),cont.getId_user(),
 * cont.getId_stock());
 * }
 * vendaRepository.updateStatus2();
 * }
 */
/*
 * if(!userFind.isEmpty() ){
 * System.out.println("venda positiva");
 * for (User_Orders cont: userFind) {
 * vendaRepository.updateDollarBalance(cont.getId_user());
 * vendaRepository.updateRemainingValue(cont.getId_stock(),cont);
 * vendaRepository.atualizarBalance(cont.getId_user(), cont.getId_stock());
 * }
 * }
 */
/*
 * if (!teste1.isEmpty()){
 * System.out.println("venda negativa");
 * for (User_Orders cont: teste1) {
 * vendaRepository.RemainingNE(cont.getId_user(), cont.getId_stock());
 * vendaRepository.updateDollarBalanceNE(cont, cont.getId_user());
 * vendaRepository.updateRemainingValue2(cont);
 * }
 * }
 * vendaRepository.updateStatus2();
 */