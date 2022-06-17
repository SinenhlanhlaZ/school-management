package za.ac.cput.schoolmanagement.service;

import za.ac.cput.schoolmanagement.domain.Country;

import java.util.List;
/*
    CountryService.java
    Nonzwakazi Mgxaji 2131815284
*/

public interface ICountryService extends IService<Country, String> {
    List<Country> findAll();

    void deleteById(String id);
}