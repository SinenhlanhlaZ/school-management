package za.ac.cput.schoolmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.repository.CountryRepository;
import za.ac.cput.schoolmanagement.service.ICountryService;

import java.util.List;
import java.util.Optional;

/*
    CountryServiceImpl.java
    Country service implementation
    Nonzwakazi Mgxaji 2131815284
*/

@Service
public class CountryServiceImpl implements ICountryService {
    private final CountryRepository repository;

    @Autowired
    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Country> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
        Optional<Country> country = read(id);
        country.ifPresent(this::delete);
    }

    @Override
    public Country save(Country country) {
        return this.repository.save(country);
    }

    @Override
    public Optional<Country> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Country country) {
        this.repository.delete(country);
    }
}
