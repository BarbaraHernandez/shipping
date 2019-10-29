package com.company.shippingdatabase.controller;

import com.company.shippingdatabase.model.Invoice;
import com.company.shippingdatabase.model.InvoiceItem;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/invoice")
public class ShippingInvoiceController {

    //add - invoice
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice addInvoice(@RequestBody Invoice invoice){
        return null;
    }

    //get one - invoice
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Invoice getInvoice(@PathVariable Integer id){
        return null;
    }

    //get all - invoice
    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Invoice> getAllInvoices(){return null;}

    //update - invoice
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateInvoice(@Valid @RequestBody Invoice invoice, @PathVariable Integer id){
        //do check
        //do update
    }

    //delete - invoice
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteInvoice(@PathVariable Integer id){
        //do delete
    }

    //add - item
    @PostMapping(value = "/item")
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceItem addInvoiceItem(@RequestBody InvoiceItem item){
        return null;
    }

    //get one - item
    @GetMapping(value = "/item/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Invoice getInvoiceItem(@PathVariable Integer id){
        return null;
    }

    //get all - item
    @GetMapping(value = "/item")
    @ResponseStatus(HttpStatus.FOUND)
    public List<InvoiceItem> getAllInvoiceItems(){return null;}

    //update - item
    @PutMapping(value = "/item/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateInvoiceItem(@Valid @RequestBody InvoiceItem item, @PathVariable Integer id){
        //do check
        //do update
    }

    //delete - item
    @DeleteMapping(value = "/item/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteInvoiceItem(@PathVariable Integer id){
        //do delete
    }

}
