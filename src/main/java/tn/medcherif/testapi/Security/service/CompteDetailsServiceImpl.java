package tn.medcherif.testapi.Security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.medcherif.testapi.DAO.CompteDao;
import tn.medcherif.testapi.Model.Compte;

@Service
public class CompteDetailsServiceImpl implements UserDetailsService {
    private final CompteDao compteDao;

    public CompteDetailsServiceImpl(CompteDao compteDao) {
        this.compteDao = compteDao;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Compte compte = compteDao.findByLogin(login)
            .orElseThrow(() -> new UsernameNotFoundException("user not found: " + login));
        return CompteDetailsImpl.build(compte);
    }
}
