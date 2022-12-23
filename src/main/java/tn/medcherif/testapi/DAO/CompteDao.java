package tn.medcherif.testapi.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.medcherif.testapi.Model.Compte;

import java.util.Optional;

@Repository
public interface CompteDao extends JpaRepository<Compte, Integer> {
    Optional<Compte> findByLogin(String login);
    Boolean existsByLogin(String login);

    boolean existsByLoginAndPassword(String login,String password);
}