package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.CategorizationRule;
import com.example.demo.service.CategorizationRuleService;

@RestController
@RequestMapping("/api/rules")
public class CategorizationRuleController {

    private final CategorizationRuleService ruleService;

    public CategorizationRuleController(
            CategorizationRuleService ruleService) {
        this.ruleService = ruleService;
    }

    // POST /api/rules/{categoryId}
    @PostMapping("/{categoryId}")
    public CategorizationRule createRule(
            @PathVariable Long categoryId,
            @RequestBody CategorizationRule rule) {
        return ruleService.createRule(categoryId, rule);
    }

    // GET /api/rules/category/{categoryId}
    @GetMapping("/category/{categoryId}")
    public List<CategorizationRule> getRulesByCategory(
            @PathVariable Long categoryId) {
        return ruleService.getRulesByCategory(categoryId);
    }

    // DELETE /api/rules/{ruleId}
    @DeleteMapping("/{ruleId}")
    public void deleteRule(@PathVariable Long ruleId) {
        ruleService.deleteRule(ruleId);
    }
}
