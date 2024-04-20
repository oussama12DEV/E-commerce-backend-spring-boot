package org.ouss.ecommercev1.repository;

import org.ouss.ecommercev1.entites.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface CtegorieRepository extends JpaRepository<Categorie,Long> {
}
