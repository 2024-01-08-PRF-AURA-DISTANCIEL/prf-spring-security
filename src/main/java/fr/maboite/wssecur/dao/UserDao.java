package fr.maboite.wssecur.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.maboite.wssecur.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	User findByLogin(String userName);

}