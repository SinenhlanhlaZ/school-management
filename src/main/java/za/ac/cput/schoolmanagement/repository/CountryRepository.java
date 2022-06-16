package za.ac.cput.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.Country;

/*
    CountryRepository.java
    Country repository
    Nonzwakazi Mgxaji 2131815284
*/

@Repository
public interface CountryRepository extends JpaRepository<Country, String>{
}