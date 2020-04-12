package security.oauth.dtos;


import lombok.Getter;
import lombok.Setter;
import security.oauth.custom_validators.ValidGST;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SellerRegistration extends UserRegistrationDto{

    @NotNull
    @NotEmpty
    @Size(min = 15, max = 15)

    @ValidGST //custom annotation
    private String GST;

    @NotNull
    @NotEmpty
    private String companyName;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
    private String companyContact;

}
