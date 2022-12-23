package tn.medcherif.testapi.Payload.Request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
@Getter
@Setter
public class SignupRequest implements Serializable {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String nom;
    @NotBlank
    private String prenom;
    @NotBlank
    private String cin;

}
