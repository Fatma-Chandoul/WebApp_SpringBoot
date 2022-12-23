package tn.medcherif.testapi.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.medcherif.testapi.Model.Personne;

import java.util.Optional;

@Repository

public interface PersonneDao extends JpaRepository<Personne, Integer> {
    Optional<Personne> findByNomAndPrenom(String nom, String prenom);
}
