// package com.example.demo.service.impl;

// import org.springframework.stereotype.Service;
// import com.example.demo.service.VendorService;
// import com.example.demo.model.Vendor;
// import com.example.demo.repository.VendorRepository;
// import java.util.List;

// @Service
// public class VendorServiceImpl implements VendorService {

//     private final VendorRepository vendorRepository;

//     public VendorServiceImpl(VendorRepository vendorRepository) {
//         this.vendorRepository = vendorRepository;
//     }

//     @Override
//     public Vendor createVendor(Vendor vendor) {
//         return vendorRepository.save(vendor);
//     }

//     @Override
//     public Vendor getVendor(Long vendorId) {
//         return vendorRepository.findById(vendorId).orElse(null);
//     }

//     @Override
//     public List<Vendor> getAllVendors() {
//         return vendorRepository.findAll();
//     }
// }
