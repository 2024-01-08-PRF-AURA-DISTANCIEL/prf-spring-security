package fr.maboite.wssecur.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.maboite.wssecur.dao.UserDao;
import fr.maboite.wssecur.model.User;

/** 
 * Permet à Spring Security de récupérer un User par son login
 */
@Service
public class DataBaseUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        User user = userDao.findByLogin(userName);
        if (user == null) {
            throw new UsernameNotFoundException(userName);
        }
        return user;
    }
}