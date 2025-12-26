// package com.example.demo.repository;
// import java.util.List;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.model.Invoice;
// import com.example.demo.model.User;
// @Repository
// public interface InvoiceRepository extends JpaRepository<Invoice, Long> {


//  }




package com.example.demo.repository;

import com.example.demo.model.Invoice;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    // Test-case exact method names
    List<Invoice> findByUploadedBy(User user);

    @Query("SELECT i FROM Invoice i WHERE i.amount > :amount")
    List<Invoice> findByAmountGreaterThanHql(Double amount);

    boolean existsByVendorIdAndInvoiceNumber(Long vendorId, String invoiceNumber);
}


