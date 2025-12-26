// package com.example.demo.controller;
// import java.util.List;
// import org.springframework.web.bind.annotation.*;
// import com.example.demo.model.CategorizationRule;
// import com.example.demo.service.CategorizationRuleService;
// @RestController
// @RequestMapping("/api/rules")
// public class CategorizationRuleController {

//     private final CategorizationRuleService ruleService;

//     public CategorizationRuleController(
//             CategorizationRuleService ruleService) {
//         this.ruleService = ruleService;
//     }
//     @PostMapping("/{categoryId}")
//     public CategorizationRule createRule(
//             @PathVariable Long categoryId,
//             @RequestBody CategorizationRule rule) {
//         return ruleService.createRule(categoryId, rule);
//     }
//     @GetMapping("/category/{categoryId}")
//     public List<CategorizationRule> getRulesByCategory(
//             @PathVariable Long categoryId) {
//         return ruleService.getRulesByCategory(categoryId);
//     }
//     @DeleteMapping("/{ruleId}")
//     public void deleteRule(@PathVariable Long ruleId) {
//         ruleService.deleteRule(ruleId);
//     }
// }




package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rules")
public class CategorizationRuleController {
    
    private final CategorizationRuleService ruleService;
    
    public CategorizationRuleController(CategorizationRuleService ruleService) {
        this.ruleService = ruleService;
    }
    
    @PostMapping
    public ResponseEntity<CategorizationRule> createRule(@RequestBody CategorizationRule rule) {
        CategorizationRule savedRule = ruleService.createRule(rule);
        return ResponseEntity.ok(savedRule);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CategorizationRule> getRule(@PathVariable Long id) {
        CategorizationRule rule = ruleService.findById(id);
        return ResponseEntity.ok(rule);
    }
}
