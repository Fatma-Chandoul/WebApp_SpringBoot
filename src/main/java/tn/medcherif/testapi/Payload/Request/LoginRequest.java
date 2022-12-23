package tn.medcherif.testapi.Payload.Request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
public class LoginRequest {
    @NotBlank(message = "Le login est obligatoire")
    private String username;
    @NotBlank(message = "Le password est obligatoire")
    private String password;
}
