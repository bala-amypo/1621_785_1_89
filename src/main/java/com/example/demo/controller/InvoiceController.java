
package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Invoice;
import com.example.demo.service.InvoiceService;

//import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/invoices")
// @Tag(name = "Invoices Endpoints")
public class InvoiceController {

    private final InvoiceService invoiceService;

    // Constructor Injection
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    // POST /api/invoices/upload/{userId}/{vendorId}
    @PostMapping("/upload/{userId}/{vendorId}")
    public Invoice uploadInvoice(
            @PathVariable Long userId,
            @PathVariable Long vendorId,
            @RequestBody Invoice invoice) {

        return invoiceService.uploadInvoice(userId, vendorId, invoice);
    }

    // POST /api/invoices/categorize/{invoiceId}
    @PostMapping("/categorize/{invoiceId}")
    public Invoice categorizeInvoice(@PathVariable Long invoiceId) {
        return invoiceService.categorizeInvoice(invoiceId);
    }

    // GET /api/invoices/user/{userId}
    @GetMapping("/user/{userId}")
    public List<Invoice> getInvoicesByUser(@PathVariable Long userId) {
        return invoiceService.getInvoicesByUser(userId);
    }

    // GET /api/invoices/{invoiceId}
    @GetMapping("/{invoiceId}")
    public Invoice getInvoice(@PathVariable Long invoiceId) {
        return invoiceService.getInvoice(invoiceId);
    }
}