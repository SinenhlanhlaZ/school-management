package za.ac.cput.schoolmanagement.repository;

/*
 *
 * Sinenhlanhla Zondi
 * 220008922
 * 12/06/20220
 *
 * */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
}
