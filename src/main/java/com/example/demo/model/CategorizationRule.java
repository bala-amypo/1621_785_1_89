// package com.example.demo.model;
// import java.time.LocalDateTime;
// // import jakarta.persistence.*;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Column;
// import jakarta.persistence.PrePersist;
// @Entity
// public class CategorizationRule {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private Long categoryId;
//     private String keyword;
//     private String matchType;
//     private Integer priority;
//     private LocalDateTime createdAt;
//     public CategorizationRule() {}
//     @PrePersist
//     public void onCreate() {
//         this.createdAt = LocalDateTime.now();
//     }

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Long getCategoryId() { return categoryId; }
//     public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

//     public String getKeyword() { return keyword; }
//     public void setKeyword(String keyword) { this.keyword = keyword; }

//     public String getMatchType() { return matchType; }
//     public void setMatchType(String matchType) { this.matchType = matchType; }

//     public Integer getPriority() { return priority; }
//     public void setPriority(Integer priority) { this.priority = priority; }

//     public LocalDateTime getCreatedAt() { return createdAt; }
// }


package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CategorizationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;
    private Integer priority;

    @Enumerated(EnumType.STRING)
    private MatchType matchType;

    @ManyToOne
    private Category category;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { this.priority = priority; }

    public MatchType getMatchType() { return matchType; }

    public void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    // ✅ REQUIRED BY TESTS
    public void setMatchType(String matchType) {
        this.matchType = MatchType.valueOf(matchType);
    }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
