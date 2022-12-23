package tn.medcherif.testapi.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.medcherif.testapi.Model.ERole;
import tn.medcherif.testapi.Model.Role;

import java.util.Optional;

public interface  RoleDao extends JpaRepository<Role, Integer> {
    Optional<Role> findByRole(ERole role);
}
