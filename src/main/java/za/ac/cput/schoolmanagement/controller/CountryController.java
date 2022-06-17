package za.ac.cput.schoolmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.service.ICountryService;
import javax.validation.Valid;
import java.util.List;

/*
    CountryController.java
    Country Controller
    Nonzwakazi Mgxaji 2131815284
*/

@RestController
@RequestMapping("school management/country/")
@Slf4j
public class CountryController {
    private final ICountryService countryService;

    @Autowired
    public CountryController(ICountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("save")
    public ResponseEntity<Country> save(@Valid @RequestBody Country country){
        Country save = countryService.save(country);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Country> read(@PathVariable String id){
        log.info("Read request: {}", id);
        Country country = this.countryService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return  ResponseEntity.ok(country);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.countryService.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Country>> findAll(){
        List<Country> country = this.countryService.findAll();
        return ResponseEntity.ok(country);
    }
}