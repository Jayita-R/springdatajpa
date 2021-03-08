package orm.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

public interface CountryRepository extends JpaRepository<Country,String>{

}
