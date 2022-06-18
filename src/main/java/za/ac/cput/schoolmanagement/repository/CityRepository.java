package za.ac.cput.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
    List<City> findCitiesByCountry(Country country);
}
