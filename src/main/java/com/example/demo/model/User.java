
// package com.example.demo.model;

// import java.time.LocalDateTime;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Column;
// import jakarta.persistence.PrePersist;

// @Entity
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String fullName;

//     @Column(unique = true)
//     private String email;

//     private String password;
//     private String role;
//     private LocalDateTime createdAt;

//     public User() {
//     }

//     public User(Long id, String fullName, String email, String password, String role) {
//         this.id = id;
//         this.fullName = fullName;
//         this.email = email;
//         this.password = password;
//         this.role = role;
//     }

//     @PrePersist
//     public void onCreate() {
//         this.createdAt = LocalDateTime.now();
//         if (this.role == null) {
//             this.role = "USER";
//         }
//     }

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getFullName() { return fullName; }
//     public void setFullName(String fullName) { this.fullName = fullName; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }

//     public String getRole() { return role; }
//     public void setRole(String role) { this.role = role; }

//     public LocalDateTime getCreatedAt() { return createdAt; }
// }












package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.UniqueConstraint;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;
    private String role;
    private LocalDateTime createdAt;

    // Many-to-Many relationship with Vendor for favorite vendors
    @ManyToMany
    @JoinTable(
        name = "user_favorite_vendors",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "vendor_id")
    )
    private Set<Vendor> favoriteVendors = new HashSet<>();

    // One-to-Many relationship with Invoice (user uploads invoices)
    @OneToMany(mappedBy = "uploadedBy")
    private List<Invoice> invoices;

    public User() {
    }

    public User(Long id, String fullName, String email, String password,
                String role, Set<Vendor> favoriteVendors, List<Invoice> invoices) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.favoriteVendors = favoriteVendors;
        this.invoices = invoices;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.role == null) {
            this.role = "USER";
        }
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public Set<Vendor> getFavoriteVendors() { return favoriteVendors; }
    public void setFavoriteVendors(Set<Vendor> favoriteVendors) {
        this.favoriteVendors = favoriteVendors;
    }

    public List<Invoice> getInvoices() { return invoices; }
    public void setInvoices(List<Invoice> invoices) { this.invoices = invoices; }
}
