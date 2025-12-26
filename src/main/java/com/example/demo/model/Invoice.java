// package com.example.demo.model;
// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.PrePersist;
// @Entity
// public class Invoice {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private Long vendorId;         
//     private String invoiceNumber;
//     private Double amount;
//     private LocalDate invoiceDate;
//     private String description;
//     private Long categoryId;       
//     private Long uploadedById;    
//     private LocalDateTime uploadedAt;
//     public Invoice() {}
//     public Invoice(Long id, Long vendorId, String invoiceNumber, Double amount,
//                    LocalDate invoiceDate, String description,
//                    Long categoryId, Long uploadedById) {
//         this.id = id;
//         this.vendorId = vendorId;
//         this.invoiceNumber = invoiceNumber;
//         this.amount = amount;
//         this.invoiceDate = invoiceDate;
//         this.description = description;
//         this.categoryId = categoryId;
//         this.uploadedById = uploadedById;
//     }

//     @PrePersist
//     public void onCreate() {
//         this.uploadedAt = LocalDateTime.now();
//     }
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public Long getVendorId() { return vendorId; }
//     public void setVendorId(Long vendorId) { this.vendorId = vendorId; }

//     public String getInvoiceNumber() { return invoiceNumber; }
//     public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }

//     public Double getAmount() { return amount; }
//     public void setAmount(Double amount) { this.amount = amount; }

//     public LocalDate getInvoiceDate() { return invoiceDate; }
//     public void setInvoiceDate(LocalDate invoiceDate) { this.invoiceDate = invoiceDate; }

//     public String getDescription() { return description; }
//     public void setDescription(String description) { this.description = description; }

//     public Long getCategoryId() { return categoryId; }
//     public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

//     public Long getUploadedById() { return uploadedById; }
//     public void setUploadedById(Long uploadedById) { this.uploadedById = uploadedById; }

//     public LocalDateTime getUploadedAt() { return uploadedAt; }
// }





package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "invoices",
    uniqueConstraints = @UniqueConstraint(columnNames = {"vendor_id","invoiceNumber"})
)
public class Invoice {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name="vendor_id", nullable=false)
    private Vendor vendor;

    @NotBlank
    private String invoiceNumber;

    @NotNull @Positive
    private Double amount;

    @NotNull
    private LocalDate invoiceDate;

    private String description;

    @ManyToOne @JoinColumn(name="category_id")
    private Category category;

    @ManyToOne @JoinColumn(name="uploaded_by_id", nullable=false)
    private User uploadedBy;

    private LocalDateTime uploadedAt;

    public Invoice() {}

    public Invoice(Vendor vendor, String invoiceNumber, Double amount,
                   LocalDate invoiceDate, String description, User uploadedBy) {
        this.vendor = vendor;
        this.invoiceNumber = invoiceNumber;
        this.amount = amount;
        this.invoiceDate = invoiceDate;
        this.description = description;
        this.uploadedBy = uploadedBy;
    }

    @PrePersist
    public void prePersist() {
        this.uploadedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }

    public String getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public LocalDate getInvoiceDate() { return invoiceDate; }
    public void setInvoiceDate(LocalDate invoiceDate) { this.invoiceDate = invoiceDate; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public User getUploadedBy() { return uploadedBy; }
    public void setUploadedBy(User uploadedBy) { this.uploadedBy = uploadedBy; }

    public LocalDateTime getUploadedAt() { return uploadedAt; }
    public void setUploadedAt(LocalDateTime uploadedAt) { this.uploadedAt = uploadedAt; }
}

