package tn.medcherif.testapi.Service;

import org.springframework.stereotype.Service;
import tn.medcherif.testapi.DAO.CompteDao;
import tn.medcherif.testapi.Model.Compte;

import java.util.Optional;


@Service
public class CompteServiceImpl implements CompteService {
    private final CompteDao compteDao;

    public CompteServiceImpl(CompteDao compteDao) {
        this.compteDao = compteDao;
    }

    @Override
    public boolean existByLogin(String login) {
        return compteDao.existsByLogin(login);
    }

    @Override
    public Compte addCompte(Compte compte) {
        return compteDao.save(compte);
    }

    @Override
    public Optional<Compte> getById(int id) {
        return compteDao.findById(id);
    }
}
