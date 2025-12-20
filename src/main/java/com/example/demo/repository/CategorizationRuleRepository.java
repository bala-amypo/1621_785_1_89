package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CategorizationRule;

@Repository
public interface CategorizationRuleRepository
        extends JpaRepository<CategorizationRule, Long> {

    // @Query("""
    //     SELECT r FROM CategorizationRule r
    //     WHERE LOWER(:description) LIKE LOWER(CONCAT('%', r.keyword, '%'))
    //     ORDER BY r.priority DESC
    // """)
    // List<CategorizationRule> findMatchingRulesByDescription(String description);
}