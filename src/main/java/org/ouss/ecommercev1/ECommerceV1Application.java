package org.ouss.ecommercev1;

import net.bytebuddy.utility.RandomString;
import org.ouss.ecommercev1.entites.*;
import org.ouss.ecommercev1.repository.CtegorieRepository;
import org.ouss.ecommercev1.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;


@SpringBootApplication
public class ECommerceV1Application {
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(ECommerceV1Application.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner (CtegorieRepository ctegoriesRepository,
                                         ProduitRepository produitRepository){
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(produit.class, Categorie.class);

            ctegoriesRepository.save(new Categorie(null,"Computer",null,null,null));
            ctegoriesRepository.save(new Categorie(null ,"Printers",null,null,null));
            ctegoriesRepository.save(new Categorie(null ,"Smart phones",null,null,null));

            Random random = new Random();

            ctegoriesRepository.findAll().forEach(x->{
                for (int i = 0; i <10 ; i++) {

                produit produit = new produit();
                produit.setName(RandomString.make(14));
                produit.setCurretPrice(100+random.nextInt(1000));
                produit.setAvailable(random.nextBoolean());
                produit.setPromotion(random.nextBoolean());
                produit.setSelected(random.nextBoolean());
                produit.setCategories(x);
                produit.setPhoto("unknown.png");
                produitRepository.save(produit);
                }


            });

        };
    }

}
