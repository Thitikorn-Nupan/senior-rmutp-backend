package com.ttknpdev.ecomercebackend.services.addresses;

import com.ttknpdev.ecomercebackend.entities.addresses.Province;
import com.ttknpdev.ecomercebackend.repositories.addresses.ProvinceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProvinceService {

    private ProvinceRepo provinceRepo;

    @Autowired
    public ProvinceService(ProvinceRepo provinceRepo) {
        this.provinceRepo = provinceRepo;
    }

    public Iterable<Province> getAllProvinces() {
        return provinceRepo.findAll();
    }

    public Optional<Province> getProvinceById(long id) {
        return provinceRepo.findById(id);
    }

}
