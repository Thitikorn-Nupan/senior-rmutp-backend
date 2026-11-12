package com.ttknpdev.ecomercebackend.controllers.addresses;

import com.ttknpdev.ecomercebackend.entities.addresses.Province;
import com.ttknpdev.ecomercebackend.services.addresses.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/province")
public class ProvinceControl {

    private final ProvinceService provinceService;

    @Autowired
    public ProvinceControl(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Province>> reads() {
        return ResponseEntity
                .accepted()
                .body(this.provinceService.getAllProvinces());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Province>> read(@PathVariable long id) {
        return ResponseEntity
                .accepted()
                .body(this.provinceService.getProvinceById(id));
    }

}
