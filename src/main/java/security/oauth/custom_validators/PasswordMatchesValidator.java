package security.oauth.custom_validators;

import security.oauth.dtos.CustomerRegistration;
import security.oauth.dtos.SellerRegistration;
import security.oauth.entities.ForgotPasswordToken;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){

        if(obj instanceof SellerRegistration){
            SellerRegistration seller = (SellerRegistration) obj;
            return seller.getPassword().equals(seller.getConfirmPassword());
        }
        else if(obj instanceof ForgotPasswordToken){
            ForgotPasswordToken passwords = (ForgotPasswordToken) obj;
            return passwords.getPassword().equals(passwords.getConfirmPassword());
        }

        CustomerRegistration customer = (CustomerRegistration) obj;
        return customer.getPassword().equals(customer.getConfirmPassword());
    }
}