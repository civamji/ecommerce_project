package security.oauth.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerAdminApi{

    private Long id;
    private String fullName;
    private String email;
    private boolean isActive;

    public String getFullName() {
        return fullName;
    }

    public CustomerAdminApi() {
    }

    public CustomerAdminApi(Long id, String fullName, String email, boolean isActive) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.isActive = isActive;
    }

    public void setFullName(String firstName, String middleName, String lastName){
        this.fullName = firstName + " " + middleName + " " +lastName;
    }

}