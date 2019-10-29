package com.company.shippingedge.controller;

import com.company.shippingedge.models.viewmodels.InvoiceViewModel;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/shipping")
public class ShippingController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel addInvoice(@RequestBody @Valid InvoiceViewModel ivm){
        return null;
    }

    @GetMapping(value = "/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceViewModel> findInvoicesByCustomerId(@PathVariable int id){
        return null;
    }
}
