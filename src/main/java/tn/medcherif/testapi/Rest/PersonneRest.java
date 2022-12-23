package tn.medcherif.testapi.Rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.medcherif.testapi.DAO.PersonneDao;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/personne/")
public class PersonneRest {
    private final PersonneDao personneDao;

    public PersonneRest(PersonneDao personneDao) {
        this.personneDao = personneDao;
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(personneDao.findAll(), HttpStatus.OK);
    }




}




