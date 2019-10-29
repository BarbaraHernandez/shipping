package com.company.shippingedge.feign;

import com.company.shippingedge.models.Invoice;
import com.company.shippingedge.models.InvoiceItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "shipping-database")
@RequestMapping(value = "/invoice")
public interface ShippingClient {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice addInvoice(@RequestBody Invoice invoice);

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Invoice getInvoice(@PathVariable Integer id);

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Invoice> getAllInvoices();

    @PostMapping(value = "/item")
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceItem addInvoiceItem(@RequestBody InvoiceItem item);

    @GetMapping(value = "/item/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public InvoiceItem getInvoiceItem(@PathVariable Integer id);

    @GetMapping(value = "/item")
    @ResponseStatus(HttpStatus.FOUND)
    public List<InvoiceItem> getAllInvoiceItems();
}
