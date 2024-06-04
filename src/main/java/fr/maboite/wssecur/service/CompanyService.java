package fr.maboite.wssecur.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.maboite.wssecur.dao.CompanyDao;
import fr.maboite.wssecur.model.Company;

@Component
public class CompanyService {

	@Autowired
	private CompanyDao companyDao;

	public Company save(Company company) {
		return companyDao.save(company);
	}

	public Company findById(Integer id) {
		Optional<Company> companyFromDao = companyDao.findById(id);
		if (companyFromDao.isEmpty()) {
			return null;
		} else {
			return companyFromDao.get();
		}

	}

}
