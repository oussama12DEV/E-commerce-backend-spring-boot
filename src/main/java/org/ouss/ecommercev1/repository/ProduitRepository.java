package org.ouss.ecommercev1.repository;

import org.ouss.ecommercev1.entites.produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface ProduitRepository extends JpaRepository<produit,Long> {
    @RestResource(path = "/selectedProduit")
    public List<produit> findBySelectedTrue();
    @RestResource(path = "/byname")
    public List<produit> findByNameContains(@Param("key") String key);

    /*@Query("select p from produit p where p.name like :p")
    public List<produit> cherch(@Param("p") String key);*/
    @RestResource(path = "/promotionProduit")
    public List<produit> findByPromotionIsTrue();
    @RestResource(path = "/DisponibleProduit")
    public List<produit> findByAvailableIsTrue();

}
