package org.ouss.ecommercev1.web;

import org.ouss.ecommercev1.entites.Client;
import org.ouss.ecommercev1.entites.produit;
import org.ouss.ecommercev1.entites.Order;
import org.ouss.ecommercev1.entites.OrderItem;
import org.ouss.ecommercev1.repository.ClientRepository;
import org.ouss.ecommercev1.repository.OrderItemRepository;
import org.ouss.ecommercev1.repository.OrderRepository;
import org.ouss.ecommercev1.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin("*")
@RestController
public class OrderController {
    @Autowired
    private ProduitRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @PostMapping("/orderss")
    public Order saveOrder(@RequestBody OrderForm orderForm){
        Client client=new Client();
        client.setName(orderForm.getClient().getName());
        client.setEmail(orderForm.getClient().getEmail());
        client.setAddress(orderForm.getClient().getAddress());
        client.setPhoneNumber(orderForm.getClient().getPhoneNumber());
        client.setUsername(orderForm.getClient().getUsername());
        client=clientRepository.save(client);
        System.out.println(client.getId());


        Order order=new Order();
        order.setClient(client);
        order.setDate(new Date());
        order=orderRepository.save(order);


        double total=0;
        for(OrderProduct p:orderForm.getProducts()){

            OrderItem orderItem=new OrderItem();
            orderItem.setOrder(order);
            produit product=productRepository.findById(p.getProduit().getId()).get();
            orderItem.setProduct(product);
            orderItem.setPrice(product.getCurretPrice());
            orderItem.setQuantity(p.getQuantity());
            orderItemRepository.save(orderItem);
            total+=p.getQuantity()*product.getCurretPrice();
        }
        order.setTotalAmount(total);
        return orderRepository.save(order);
    }

}
