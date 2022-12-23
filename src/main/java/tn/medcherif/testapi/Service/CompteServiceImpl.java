package tn.medcherif.testapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.essatin.erp.Service.CompteService;
import tn.essatin.erp.dao.CompteDao;
import tn.essatin.erp.model.Compte;

@Service
public class CompteServiceImpl implements CompteService {
    @Autowired
    CompteDao compteDao;

    @Override
    public boolean existByLogin(String login) {
        return compteDao.existsByLogin(login);
    }

    @Override
    public Compte addCompte(Compte compte) {
        return compteDao.save(compte);
    }
}
