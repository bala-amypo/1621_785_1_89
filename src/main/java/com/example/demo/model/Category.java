// package com.example.demo.model;
// import java.time.LocalDateTime;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Column;
// import jakarta.persistence.PrePersist;
// @Entity
// public class Category {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     @Column(unique = true)
//     private String categoryName;
//     private String description;
//     private LocalDateTime createdAt;
//     public Category() {
//     }
//     public Category(Long id, String categoryName, String description) {
//         this.id = id;
//         this.categoryName = categoryName;
//         this.description = description;
//     }
//     @PrePersist
//     public void onCreate() {
//         this.createdAt = LocalDateTime.now();
//     }
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public String getCategoryName() { return categoryName; }
//     public void setCategoryName(String categoryName) {
//         this.categoryName = categoryName;
//     }

//     public String getDescription() { return description; }
//     public void setDescription(String description) {
//         this.description = description;
//     }

//     public LocalDateTime getCreatedAt() { return createdAt; }
// }
