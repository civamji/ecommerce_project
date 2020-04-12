package security.oauth.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import security.oauth.dtos.CustomerAdminApi;
import security.oauth.dtos.SellerAdminApi;
import security.oauth.services.CustomerService;
import security.oauth.services.ProductService;
import security.oauth.services.SellerService;
import security.oauth.services.UserService;
import security.oauth.utils.ResponseVariationOrder;
import security.oauth.utils.VariationOrder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;


    @GetMapping("/admin/home")
    public ResponseEntity<VariationOrder> getAdminHome(){
        String message = "Admin home";
        VariationOrder response = new ResponseVariationOrder<>(null, message, new Date());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<VariationOrder> getAllCustomers(@RequestParam(defaultValue = "0") String offset,
                                              @RequestParam(defaultValue = "10") String size,
                                              @RequestParam(defaultValue = "id") String sortByField,
                                              @RequestParam(required = false) String email){

        VariationOrder response;
        ResponseEntity<VariationOrder> responseEntity;
        List<CustomerAdminApi> list = new ArrayList<>();
        if(email!=null){
            CustomerAdminApi customerAdminApi = customerService.getCustomerByEmail(email);
            if(customerAdminApi != null) {
                list.add(customerAdminApi);
                response = new ResponseVariationOrder<>(list, null, new Date());
                responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
            }
            else {
                response = new ResponseVariationOrder<>(null, "No user found with this email id.", new Date());
                responseEntity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        }
        else {
            list = customerService.getAllCustomers(offset, size, sortByField);
            response = new ResponseVO<List>(list, null, new Date());
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        }
        return responseEntity;
    }

    @GetMapping("/sellers")
    public ResponseEntity<VO> getAllSellers(@RequestParam(defaultValue = "0") String offset,
                                            @RequestParam(defaultValue = "10") String size,
                                            @RequestParam(defaultValue = "id") String sortByField,
                                            @RequestParam(required = false) String email) {

        VO response;
        ResponseEntity<VariationOrder> responseEntity;
        List<SellerAdminApi> list = new ArrayList<>();
        if(email!=null){
            SellerAdminApi sellerAdminApiDto = sellerService.getSellerByEmail(email);
            if(sellerAdminApiDto != null) {
                list.add(sellerAdminApiDto);
                response = new ResponseVariationOrder<List>(list, null, new Date());
                responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
            }
            else {
                response = new ResponseVO<List>(null, "No user found with this email id.", new Date());
                responseEntity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        }
        else {
            list = sellerService.getAllSellers(offset, size, sortByField);
            response = new ResponseVariationOrder<List>(list, null, new Date());
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        }
        return responseEntity;
    }

//    @GetMapping("/products")
//    public ResponseEntity<VO>getAllProducts(){
//        List<Product> list = productService.getAllProducts();
//        VO response = new ResponseVO<>(list, null, new Date());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }


    @PutMapping("/activate/{id}")
    public ResponseEntity<VariationOrder> activateUser(@PathVariable Long id, WebRequest request){
        return userService.activateUserById(id, request);
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<VariationOrder> deactivateUser(@PathVariable Long id, WebRequest request){
        return userService.deactivateUserById(id, request);
    }

}
