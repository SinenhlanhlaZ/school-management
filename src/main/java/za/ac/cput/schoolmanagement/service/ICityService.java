package za.ac.cput.schoolmanagement.service;

import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;

import java.util.List;

public interface ICityService extends IService<City, String> {
    List<City> findAll();

    public void deleteById(String id);

    List<City> findCitiesByCountry(Country country);
}
