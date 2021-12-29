package com.adminpanel.adminpanel.controller;

import com.adminpanel.adminpanel.model.Product;
import com.adminpanel.adminpanel.model.StringResponse;
import com.adminpanel.adminpanel.model.User;
import com.adminpanel.adminpanel.service.ProductService;
import com.adminpanel.adminpanel.service.TransactionService;
import com.adminpanel.adminpanel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    private UserService userService;
    private ProductService productService;
    private TransactionService transactionService;

    @Autowired
    public AdminController(UserService userService, ProductService productService, TransactionService transactionService) {
        this.userService = userService;
        this.productService = productService;
        this.transactionService = transactionService;
    }

    @PutMapping("/api/admin/user-update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        User u = userService.findByUsername(user.getUsername());
        if(u != null && !u.getId().equals(user.getId())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(userService.updateUser(user), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/api/admin/user-delete")
    public ResponseEntity<?> deleteUser(@RequestBody User user) {
        userService.deleteUser(user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/admin/user-all")
    public ResponseEntity<?> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/api/admin/user-number")
    public ResponseEntity<?> numberOfUsers() {
        Long number = userService.numberOfUsers();
        StringResponse stringResponse = new StringResponse();
        stringResponse.setResponse(number.toString());
        return new ResponseEntity<>(stringResponse, HttpStatus.OK);
    }

    @PostMapping("/api/admin/product-create")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @PostMapping("/api/admin/product-update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/api/admin/product-delete")
    public ResponseEntity<?> deleteProduct(@RequestBody Product product) {
        productService.deleteProduct(product.getId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/admin/product-all")
    public ResponseEntity<?> findAllProducts() {
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/api/admin/product-number")
    public ResponseEntity<?> numberOfProducts() {
        Long number = productService.numberOfProducts();
        StringResponse stringResponse = new StringResponse();
        stringResponse.setResponse(number.toString());
        return new ResponseEntity<>(stringResponse, HttpStatus.OK);
    }

    @GetMapping("/api/admin/transaction-all")
    public ResponseEntity<?> findAllTransactions() {
        return new ResponseEntity<>(transactionService.findAllTransactions(), HttpStatus.OK);
    }

    @GetMapping("/api/admin/transaction-number")
    public ResponseEntity<?> numberOfTransactions() {
        return new ResponseEntity<>(transactionService.numberOfTransactions(), HttpStatus.OK);
    }

}
