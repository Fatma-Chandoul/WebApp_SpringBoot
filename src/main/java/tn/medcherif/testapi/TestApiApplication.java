package tn.medcherif.testapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import tn.medcherif.testapi.DAO.RoleDao;
import tn.medcherif.testapi.Model.ERole;
import tn.medcherif.testapi.Model.Role;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TestApiApplication {
    private final RoleDao roleDao;

    public TestApiApplication(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestApiApplication.class, args);
    }

    @PostConstruct
    public void init(){
        List<Role> roles = roleDao.findAll();
        if (roles.isEmpty()) {
            Arrays.stream(ERole.values()).forEach(eRole -> roleDao.save(new Role(eRole)));
        }
    }

}
