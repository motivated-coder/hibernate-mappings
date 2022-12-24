package com.skd.bidirectional.controller;

import com.skd.bidirectional.model.Product;
import com.skd.bidirectional.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/fetchAll")
    public ResponseEntity getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity(products, HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity saveProduct(@RequestBody Product product){
        Product s = productService.saveProduct(product);
        HttpHeaders headers = new HttpHeaders();
        headers.add("id", String.valueOf(s.getId()));
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity getProductById(@PathVariable int id){
        Product Product = productService.getById(id);
        return new ResponseEntity(Product, HttpStatus.OK);
    }
}









