package tn.medcherif.testapi.Service;


import tn.medcherif.testapi.Model.Compte;

import java.util.Optional;

public interface CompteService {
    boolean existByLogin(String login);

    Compte addCompte(Compte compte);
    Optional<Compte> getById(int id);

}
