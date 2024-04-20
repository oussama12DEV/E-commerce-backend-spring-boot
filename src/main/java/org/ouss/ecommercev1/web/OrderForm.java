package org.ouss.ecommercev1.web;

import lombok.Data;
import org.ouss.ecommercev1.entites.*;

import java.util.ArrayList;
import java.util.List;
@Data
public class OrderForm {
    private Client client=new Client();
    private List<OrderProduct> products=new ArrayList<>();
}
@Data
class OrderProduct{
    private Long id;
    private int quantity;
    private produit produit;

}
