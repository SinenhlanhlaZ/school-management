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
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.repository.AddressRepository;
import za.ac.cput.schoolmanagement.repository.EmployeeRepository;
import za.ac.cput.schoolmanagement.service.IAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {

    private final AddressRepository addrRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addRepository)
    {
        this.addrRepository = addRepository;
    }

    @Override
    public List<Address> findAll() {
        return this.addrRepository.findAll();
    }

    @Override
    public Address save(Address address) {
        return this.addrRepository.save(address);
    }

    @Override
    public Optional<Address> read(String s) {
        //not sure what to return since there is no primary key (id) for this entity
        //code below is just for testing
        return this.addrRepository.findById(s);
    }

    @Override
    public void delete(Address address) {
        this.addrRepository.delete(address);
    }
}
