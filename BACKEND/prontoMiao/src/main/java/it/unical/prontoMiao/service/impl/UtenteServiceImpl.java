package it.unical.prontoMiao.service.impl;

import it.unical.prontoMiao.persistenza.DBManager;
import it.unical.prontoMiao.persistenza.dao.UtenteDao;
import it.unical.prontoMiao.persistenza.dao.postgres.UtenteDaoPostgres;
import it.unical.prontoMiao.repository.UtenteRepository;
import it.unical.prontoMiao.service.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UtenteServiceImpl implements UtenteService {

    //@Autowired
    //private UtenteRepository utenteRepository;

    private UtenteDao utenteRepository = new UtenteDaoPostgres(DBManager.getInstance().getConnection());

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return utenteRepository.findByEmailIgnoreCase(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

}
