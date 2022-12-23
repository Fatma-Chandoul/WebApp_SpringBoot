package tn.medcherif.testapi.Payload.Response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type ;
    private Integer id;
    private List<String> role;
    private String prenom;
    private String nom;

    public JwtResponse(String token, Integer id, List<String> role, String prenom, String nom) {
        this.token = token;
        this.id = id;
        this.role = role;
        this.prenom = prenom;
        this.nom = nom;
        type = "Bearer";
    }
}
