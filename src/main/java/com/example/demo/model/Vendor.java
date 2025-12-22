package com.example.demo.model;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String vendorName;
    private String contactEmail;
    private String address;
    private LocalDateTime createdAt;

    public Vendor() {
    }

    public Vendor(Long id, String vendorName, String contactEmail,
                  String address) {
        this.id = id;
        this.vendorName = vendorName;
        this.contactEmail = contactEmail;
        this.address = address;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVendorName() { return vendorName; }
    public void setVendorName(String vendorName) { this.vendorName = vendorName; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
