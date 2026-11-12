package com.ttknpdev.ecomercebackend.services.addresses;

import com.ttknpdev.ecomercebackend.entities.addresses.District;
import com.ttknpdev.ecomercebackend.repositories.addresses.DistrictRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {
    private DistrictRepo districtRepo;

    @Autowired
    public DistrictService(DistrictRepo districtRepo) {
        this.districtRepo = districtRepo;
    }

    public List<District> getAllDistrictsByProvinceName(String provinceName) {
        return districtRepo.findByProvinceName(provinceName);
    }

}
