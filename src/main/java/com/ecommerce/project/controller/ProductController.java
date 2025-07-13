package com.ecommerce.project.controller;

import com.ecommerce.project.model.Product;
import com.ecommerce.project.payload.ProductDTO;
import com.ecommerce.project.payload.ProductResponse;
import com.ecommerce.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/admin/categories/{categoryId}/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDT0,
                                                 @PathVariable Long categoryId){

        ProductDTO productDTOSaved = productService.addProduct(categoryId, productDT0);

        return new ResponseEntity<>(productDTOSaved, HttpStatus.CREATED);
    }

    @GetMapping("/public/products")
    public ResponseEntity<ProductResponse> getallProducts(){
        ProductResponse productResponse = productService.getAllProducts();
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping("/public/categories/{categoryId}/products")
    public ResponseEntity<ProductResponse> getProductByCategory(@PathVariable Long categoryId){
        ProductResponse productResponse = productService.seachByCategory(categoryId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
}
