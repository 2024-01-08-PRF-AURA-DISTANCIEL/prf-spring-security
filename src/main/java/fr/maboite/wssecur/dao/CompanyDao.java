package fr.maboite.wssecur.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.maboite.wssecur.model.Company;

@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

}