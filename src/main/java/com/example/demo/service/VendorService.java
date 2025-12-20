package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Vendor;

public interface VendorService {

    Vendor createVendor(Vendor vendor);

    Vendor getVendor(Long vendorId);

    List<Vendor> getAllVendors();
}