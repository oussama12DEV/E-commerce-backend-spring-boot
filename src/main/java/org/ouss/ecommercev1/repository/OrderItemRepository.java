package org.ouss.ecommercev1.repository;

import org.ouss.ecommercev1.entites.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
