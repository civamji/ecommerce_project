package security.oauth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import security.oauth.dtos.CustomerRegistration;
import security.oauth.dtos.SellerRegistration;
import security.oauth.repos.CustomerRepository;
import security.oauth.repos.SellerRepository;
import security.oauth.repos.UserRepository;
import security.oauth.services.CustomerService;
import security.oauth.services.EmailService;
import security.oauth.services.SellerService;
import security.oauth.utils.VariationOrder;
import springfox.documentation.service.ResponseMessage;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@RestController
public class RegistrationController {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MessageSource messages;

    @Autowired

    private UserServ
    //private UserService userService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    EmailService emailService;

    @PostMapping("/register/customer")
    public ResponseEntity<VariationOrder> registerCustomer(@Valid @RequestBody CustomerRegistration customerDto, WebRequest request){
        return userService.createNewCustomer(customerDto, request);
    }


    @GetMapping("/activate/customer")
    public ResponseEntity<VariationOrder> activateCustomer(@RequestParam("token") String token, WebRequest request){
        return userService.activateUserByToken(token, request);
    }


    @PostMapping("/resend-activation-link/customer")
    public ResponseEntity<VariationOrder> resendActivationLink(@RequestBody String email, WebRequest request){
        return userService.resendActivationLink(email, request);
    }


    @PostMapping("/register/seller")
    public ResponseEntity<VariationOrder> registerSeller(@Valid @RequestBody SellerRegistration sellerRegistrationDto){
        return userService.createNewSeller(sellerRegistrationDto);
    }
}