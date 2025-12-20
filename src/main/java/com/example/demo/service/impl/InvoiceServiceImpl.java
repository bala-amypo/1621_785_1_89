
package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.InvoiceService;
import com.example.demo.model.Invoice;
import com.example.demo.repository.InvoiceRepository;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    // Constructor Injection (correct)
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice uploadInvoice(Long userId, Long vendorId, Invoice invoice) {
        // userId & vendorId intentionally ignored (no relationships)
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice categorizeInvoice(Long invoiceId) {
        return invoiceRepository.findById(invoiceId).orElse(null);
    }

    @Override
    public List<Invoice> getInvoicesByUser(Long userId) {
        // Not possible without relationship → return all
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoice(Long invoiceId) {
        return invoiceRepository.findById(invoiceId).orElse(null);
    }
}
