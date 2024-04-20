package org.ouss.ecommercev1.web;
import org.ouss.ecommercev1.entites.produit;
import org.ouss.ecommercev1.repository.ProduitRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin("*")
public class CategorieController {
    private ProduitRepository produitRepository;

    public CategorieController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }
    @GetMapping(path = "/image/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getimage(@PathVariable(name = "id") long id) throws Exception{
         produit produit = produitRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecom/produit/"+ produit.getPhoto()));
    }
    @PostMapping(path = "/uploadphoto/{id}")
    public void uploadphoto(MultipartFile file,@PathVariable long id) throws Exception{
        produit produit = produitRepository.findById(id).get();
        produit.setPhoto(id+".png");
        Files.write(Paths.get(System.getProperty("user.home")+"/ecom/produit/"+ produit.getPhoto()),file.getBytes());
        produitRepository.save(produit);
    }
}
