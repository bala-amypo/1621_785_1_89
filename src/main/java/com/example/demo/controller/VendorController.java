// package com.example.demo.controller;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import java.util.List;
// import com.example.demo.model.Vendor;
// import com.example.demo.service.VendorService;
// @RestController
// @RequestMapping("/api/vendors")
// public class VendorController {

//     private final VendorService vendorService;


//     public VendorController(VendorService vendorService) {
//         this.vendorService = vendorService;
//     }


//     @PostMapping
//     public Vendor createVendor(@RequestBody Vendor vendor) {
//         return vendorService.createVendor(vendor);
//     }

//     @GetMapping
//     public List<Vendor> getAllVendors() {
//         return vendorService.getAllVendors();
//     }

//     @GetMapping("got/{vendorId}")
//     public Vendor getVendor(@PathVariable Long vendorId) {
//         return vendorService.getVendor(vendorId);
//     }
// }




package com.example.demo.controller;

import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
@Tag(name = "Vendors")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) { this.vendorService = vendorService; }

    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }

    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{vendorId}")
    public Vendor getVendor(@PathVariable Long vendorId) {
        return vendorService.getVendor(vendorId);
    }
}

