package com.example.demo.util;
import com.example.demo.model.*;
import org.springframework.stereotype.Component;
import java.util.Comparator;
import java.util.List;
@Component
public class InvoiceCategorizationEngine {

    public Category determineCategory(
            Invoice invoice,
            List<CategorizationRule> rules) {

        if (invoice == null || rules == null) {
            return null;
        }

        String description = invoice.getDescription().toLowerCase();

        return rules.stream()
                .sorted(Comparator.comparing(CategorizationRule::getPriority).reversed())
                .filter(rule -> matchesRule(description, rule))
                .map(CategorizationRule::getCategory)
                .findFirst()
                .orElse(null);
    }

    private boolean matchesRule(String description, CategorizationRule rule) {
        if (rule.getMatchType() == null || rule.getKeyword() == null) {
            return false;
        }

        String keyword = rule.getKeyword().toLowerCase();
        String matchType = rule.getMatchType().toUpperCase();

        switch (matchType) {
            case "EXACT":
                return description.equals(keyword);

            case "CONTAINS":
                return description.contains(keyword);

            case "REGEX":
                return description.matches(keyword);

            default:
                return false;
        }
    }
}
