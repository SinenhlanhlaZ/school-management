package za.ac.cput.schoolmanagement.service;

/*
 *
 * Sinenhlanhla Zondi
 * 220008922
 * 12/06/20220
 *
 * */

import za.ac.cput.schoolmanagement.domain.Address;
import java.util.List;

public interface IAddressService extends IService<Address, String>{
    List<Address> findAll();
}
