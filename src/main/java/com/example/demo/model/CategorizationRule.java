package com.example.demo.model;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;

@Entity
public class CategorizationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String keyword;
    private String matchType;
    private Integer priority;
    private LocalDateTime createdAt;
    public CategorizationRule() {
    }
    public CategorizationRule(Long id, Category category,String keyword, String matchType,Integer priority) {
        this.id = id;
        this.category = category;
        this.keyword = keyword;
        this.matchType = matchType;
        this.priority = priority;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    public Long getId() {
         return id;
          }
    public void setId(Long id) { 
        this.id = id;
         }
    public Category getCategory() { 
    return category;
     }
    public void setCategory(Category category) {
        this.category = category;
    }
    public String getKeyword() { 
    return keyword;
     }
    public void setKeyword(String keyword) { 
        this.keyword = keyword;
         }

    public String getMatchType() { 
        return matchType;
         }
    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public Integer getPriority() {
         return priority; 
         }
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreatedAt() { 
        return createdAt; 
        }
}
