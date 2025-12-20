
package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long vendorId;         // reference to vendor by ID
    private String invoiceNumber;
    private Double amount;
    private LocalDate invoiceDate;
    private String description;
    private Long categoryId;       // reference to category by ID
    private Long uploadedById;     // reference to user by ID
    private LocalDateTime uploadedAt;

    public Invoice() {}

    public Invoice(Long id, Long vendorId, String invoiceNumber, Double amount,
                   LocalDate invoiceDate, String description,
                   Long categoryId, Long uploadedById) {
        this.id = id;
        this.vendorId = vendorId;
        this.invoiceNumber = invoiceNumber;
        this.amount = amount;
        this.invoiceDate = invoiceDate;
        this.description = description;
        this.categoryId = categoryId;
        this.uploadedById = uploadedById;
    }

    @PrePersist
    public void onCreate() {
        this.uploadedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getVendorId() { return vendorId; }
    public void setVendorId(Long vendorId) { this.vendorId = vendorId; }

    public String getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public LocalDate getInvoiceDate() { return invoiceDate; }
    public void setInvoiceDate(LocalDate invoiceDate) { this.invoiceDate = invoiceDate; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public Long getUploadedById() { return uploadedById; }
    public void setUploadedById(Long uploadedById) { this.uploadedById = uploadedById; }

    public LocalDateTime getUploadedAt() { return uploadedAt; }
}
