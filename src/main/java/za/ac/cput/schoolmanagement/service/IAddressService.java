package za.ac.cput.schoolmanagement.service;

import za.ac.cput.schoolmanagement.domain.Address;

import java.util.List;

public interface IAddressService extends IService<Address, String>{
    List<Address> findAll();
}
