package za.ac.cput.schoolmanagement.service.impl;

/*
 *
 * Sinenhlanhla Zondi
 * 220008922
 * 12/06/20220
 *
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.repository.CityRepository;
import za.ac.cput.schoolmanagement.service.ICityService;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements ICityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void deleteById(String id) {
        cityRepository.deleteById(id);
        Optional<City> city = read(id);
        if (city.isPresent()) {
            delete(city.get());
        }
    }


    @Override
    public List<City> findAll() {
        return this.cityRepository.findAll();
    }

    @Override
    public City save(City c) {
        return this.cityRepository.save(c);
    }

    @Override
    public Optional<City> read(String id) {
        return this.cityRepository.findById(id);
    }

    @Override
    public void delete(City c) {
        this.cityRepository.delete(c);
    }

    /*  Question 7
        Code a service to return the list of all cities in a given country.
        The parameter passed is the countryId.
         The return value is either a sorted list of city names or null (if no cities found for that countryId).*/
    @Override
    public List<City> findCitiesByCountry(Country country) {
        try {
            return this.cityRepository.findCitiesByCountry(country);
        } catch (Exception i) {
            System.out.println(i.getMessage());
        }
        return null;
    }

}
