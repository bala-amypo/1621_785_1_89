package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Invoice;
import com.example.demo.model.User;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

//      List<Invoice> findByUploadedBy(User user);

//     // @Query("SELECT i FROM Invoice i WHERE i.amount > ?1")
//      List<Invoice> findByAmountGreaterThanHql(Double amount);
 }
