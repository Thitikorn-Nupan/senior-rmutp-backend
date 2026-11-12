package com.ttknpdev.ecomercebackend.repositories.addresses;

import com.ttknpdev.ecomercebackend.entities.addresses.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DistrictRepo extends JpaRepository<District, Long> {
    List<District> findByProvinceName(@Param("provinceName") String provinceName);
}
