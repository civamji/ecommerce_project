package security.oauth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import security.oauth.entities.Product;
import security.oauth.repos.ProductRepository;
import security.oauth.services.UserService;
import security.oauth.utils.ResponseVariationOrder;

import java.util.Date;
import java.util.List;

public class CustomerController {
    @Autowired
    private TokenStore tokenStore;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserService userService;

    //Testing
    @GetMapping("/hello")
    public void printinghello(){
        System.out.println("hello there");
    }

    @GetMapping("/customer/home")
    public ResponseEntity<ResponseVariationOrder> getCustomerHome(){

        List<Product> products = (List)productRepository.findAll();
        ResponseVariationOrder<List> response = new ResponseVariationOrder<>(products, null, new Date());
        return new ResponseEntity<ResponseVariationOrder>(response, HttpStatus.OK);
    }
}
