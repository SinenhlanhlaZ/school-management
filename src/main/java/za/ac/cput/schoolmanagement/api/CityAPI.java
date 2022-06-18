package za.ac.cput.schoolmanagement.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.service.ICityService;
import za.ac.cput.schoolmanagement.service.ICountryService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CityAPI {

    private final ICityService iCityService;
    private final ICountryService iCountryService;

    @Autowired
    public CityAPI(ICityService iCityService, ICountryService iCountryService) {
        this.iCityService = iCityService;
        this.iCountryService = iCountryService;
    }

    /*  Question 7
        Code a service to return the list of all cities in a given country.
        The parameter passed is the countryId.
        The return value is either a sorted list of city names or null (if no cities found for that countryId).*/
    public List<String> findCitiesByCountry(String countryId) {
        try {
            Country country = this.iCountryService.read(countryId).get();
            List<City> citiesFound = this.iCityService.findCitiesByCountry(country);
            if (citiesFound != null && citiesFound.size() > 0) {
                List<String> cityList = new ArrayList<>();
                citiesFound.forEach(city -> cityList.add(city.getName()));
                Collections.sort(cityList);
                return cityList;
            }
        } catch (Exception i) {
            System.out.println(i.getMessage());
        }
        return null;
    }
}
