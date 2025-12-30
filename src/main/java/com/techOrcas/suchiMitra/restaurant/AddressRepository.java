package com.techOrcas.suchiMitra.restaurant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    // Find address by city
    List<Address> findByCity(String city);

    // Find address by postal code
    Address findByPostalCode(String postalCode);

    // Check if address exists for given postal code
    boolean existsByPostalCode(String postalCode);
}
