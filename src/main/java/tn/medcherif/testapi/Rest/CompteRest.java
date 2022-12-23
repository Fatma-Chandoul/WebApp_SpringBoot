package tn.medcherif.testapi.Rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.medcherif.testapi.DAO.CompteDao;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/compte/")
public class CompteRest {

    private final CompteDao compteDao;

    public CompteRest(CompteDao compteDao) {
        this.compteDao = compteDao;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(compteDao.findAll(), HttpStatus.OK);
    }
}
