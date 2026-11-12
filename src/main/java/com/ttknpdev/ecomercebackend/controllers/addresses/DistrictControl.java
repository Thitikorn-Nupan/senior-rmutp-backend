package com.ttknpdev.ecomercebackend.controllers.addresses;

import com.ttknpdev.ecomercebackend.entities.addresses.District;
import com.ttknpdev.ecomercebackend.services.addresses.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/district")
public class DistrictControl {
    private DistrictService districtService;

    @Autowired
    public DistrictControl(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping(value = "/{provinceName}")
    public ResponseEntity<List<District>> reads(@PathVariable("provinceName") String provinceName) {
        return ResponseEntity
                .accepted()
                .body(this.districtService.getAllDistrictsByProvinceName(provinceName));
    }
}
