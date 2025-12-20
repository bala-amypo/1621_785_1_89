// package com.example.demo.repository;
// import java.util.List;
// import org.springframework.stereotype.Repository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import com.example.demo.model.CategorizationRule;

// @Repository
// public interface CategorizationRuleRepository extends JpaRepository<CategorizationRule, Long> {

//     @Query("SELECT r FROM CategorizationRule r WHERE LOWER(:description) LIKE CONCAT('%', LOWER(r.keyword), '%') ORDER BY r.priority DESC")
//     List<CategorizationRule> findMatchingRulesByDescription(
//             @Param("description") String description);

// }




package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CategorizationRule;

@Repository
public interface CategorizationRuleRepository extends JpaRepository<CategorizationRule, Long> {

    List<CategorizationRule> findByKeywordContainingIgnoreCaseOrderByPriorityDesc(String keyword);

}