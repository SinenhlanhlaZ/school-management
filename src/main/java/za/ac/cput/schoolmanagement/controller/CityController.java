package za.ac.cput.schoolmanagement.controller;

/*
 *
 * Sinenhlanhla Zondi
 * 220008922
 * 12/06/20220
 *
 * */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.service.ICityService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("schoolmanagement/city/")
@Slf4j
public class CityController {

    private ICityService cityService;

    @Autowired
    CityController(ICityService cityService)
    {
        this.cityService = cityService;
    }

    @PostMapping("save")
    public ResponseEntity<City> save(@Valid @RequestBody City city) {
        log.info("Save city: {}", city);
        City saveCity = cityService.save(city);
        return ResponseEntity.ok(saveCity);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<City> read(@PathVariable String id) {
        log.info("Read city: {}", id);
        //read city from id or else throw a not found response
        City readCity = this.cityService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(readCity);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("delete city: {}", id);
        this.cityService.deleteById(id);
        //once deleted return 'no content'
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<City>> findAll() {
        List<City> allCities = this.cityService.findAll();
        return ResponseEntity.ok(allCities);
    }

}
