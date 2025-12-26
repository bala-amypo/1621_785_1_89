// package com.example.demo.controller;
// import java.util.List;
// import org.springframework.web.bind.annotation.*;
// import com.example.demo.model.Invoice;
// import com.example.demo.service.InvoiceService;
// @RestController
// @RequestMapping("/api/invoices")
// public class InvoiceController {

//     private final InvoiceService invoiceService;
//     public InvoiceController(InvoiceService invoiceService) {
//         this.invoiceService = invoiceService;
//     }
//     @PostMapping("/upload/{userId}/{vendorId}")
//     public Invoice uploadInvoice(
//             @PathVariable Long userId,
//             @PathVariable Long vendorId,
//             @RequestBody Invoice invoice) {

//         return invoiceService.uploadInvoice(userId, vendorId, invoice);
//     }

//     @PostMapping("/categorize/{invoiceId}")
//     public Invoice categorizeInvoice(@PathVariable Long invoiceId) {
//         return invoiceService.categorizeInvoice(invoiceId);
//     }

//     @GetMapping("/user/{userId}")
//     public List<Invoice> getInvoicesByUser(@PathVariable Long userId) {
//         return invoiceService.getInvoicesByUser(userId);
//     }


//     @GetMapping("ig/{invoiceId}")
//     public Invoice getInvoice(@PathVariable Long invoiceId) {
//         return invoiceService.getInvoice(invoiceId);
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.Invoice;
import com.example.demo.service.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    
    private final InvoiceService invoiceService;
    
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    
    @PostMapping("/upload")
    public ResponseEntity<Invoice> uploadInvoice(@RequestParam Long userId, 
                                               @RequestParam Long vendorId,
                                               @RequestBody Invoice invoice) {
        Invoice savedInvoice = invoiceService.uploadInvoice(userId, vendorId, invoice);
        return ResponseEntity.ok(savedInvoice);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoice(@PathVariable Long id) {
        Invoice invoice = invoiceService.getInvoice(id);
        return ResponseEntity.ok(invoice);
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Invoice>> getInvoicesByUser(@PathVariable Long userId) {
        List<Invoice> invoices = invoiceService.getInvoicesByUser(userId);
        return ResponseEntity.ok(invoices);
    }
}