package org.ouss.ecommercev1.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @AllArgsConstructor @NoArgsConstructor
@Data
public class produit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String name;
    private String photo;
    private double curretPrice;
    private boolean promotion;
    private boolean selected;
    private boolean available;
    @ManyToOne
    private Categorie categories;
    @Transient
    private int quantite=1;













}
