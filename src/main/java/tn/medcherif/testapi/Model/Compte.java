package tn.medcherif.testapi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String login;
    @JsonIgnore
    String password;
    @OneToOne(cascade = CascadeType.ALL )
    Personne personne;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "compte_role", joinColumns = @JoinColumn(name = "compte_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles;


    public Compte() {
        roles = new HashSet<>();
    }

    public Compte(Integer id, String login, String password, Personne personne) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.personne = personne;
        roles =new HashSet<>();
    }

    public Compte(String login, String password, Personne personne) {
        this.login = login;
        this.password = password;
        this.personne = personne;
        roles = new HashSet<>();
    }

    public Compte(Integer id, String login, String password, Personne personne, Set<Role> roles) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.personne = personne;
        this.roles = roles;
    }

    public Compte(String login, String password, Personne personne, Set<Role> roles) {
        this.login = login;
        this.password = password;
        this.personne = personne;
        this.roles = roles;
    }

    public void addRole(Role role){
        roles.add(role);
    }
}

