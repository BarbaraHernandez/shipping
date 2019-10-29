package com.company.shippingedge.service;

import com.company.shippingedge.feign.ShippingClient;
import com.company.shippingedge.models.Invoice;
import com.company.shippingedge.models.InvoiceItem;
import com.company.shippingedge.models.viewmodels.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceLayer {
    private ShippingClient shippingClient;

    @Autowired

    public ServiceLayer(ShippingClient shippingClient) {
        this.shippingClient = shippingClient;
    }

    public InvoiceViewModel buildInvoiceViewModel(Invoice invoice){
        InvoiceViewModel ivm = new InvoiceViewModel();
        List<InvoiceItem> items = shippingClient.getAllInvoiceItems().stream()
                .filter(invoiceItem -> invoiceItem.getInvoiceId() == invoice.getId()).collect(Collectors.toList());
        ivm.setId(invoice.getId());
        ivm.setCustomerId(invoice.getCustomerId());
        ivm.setZip(invoice.getZip());
//        ivm.setPurchaseDate(invoice.getPurchaseDate);
        ivm.setTotal(invoice.getTotal());
        ivm.setTax(invoice.getTax());
        ivm.setSurcharge(invoice.getSurcharge());
        ivm.setItems(items);
        return ivm;
    }

    public InvoiceViewModel addInvoice(InvoiceViewModel ivm){
        Invoice invoice = new Invoice();
        invoice.setCustomerId(ivm.getCustomerId());
        invoice.setZip(ivm.getZip());
//        invoice.setPurchaseDate(ivm.getPurchaseDate());
        BigDecimal totalCost = new BigDecimal("0.00");
        Float totalWeight = 0.00f;

        for (int i = 0; i < ivm.getItems().size(); i ++){

            InvoiceItem invoiceItem = ivm.getItems().get(i);

            String firstNum = ivm.getZip().substring(0,1);
            switch (firstNum){
                case "0":
                case "1":
                case "2":
                    invoiceItem.setShipCost(new BigDecimal("9.99"));
                    break;
                case "3":
                    invoiceItem.setShipCost(new BigDecimal("14.99"));
                    break;
                case "4":
                case "5":
                case "6":
                    invoiceItem.setShipCost(new BigDecimal("19.99"));
                    break;
                case "7":
                case "8":
                case "9":
                    invoiceItem.setShipCost(new BigDecimal("50.00"));
            }
            shippingClient.addInvoiceItem(invoiceItem);
            totalCost = totalCost.add(invoiceItem.getShipCost());
            totalWeight = totalWeight + invoiceItem.getWeight();
        };
        BigDecimal totalSurcharge;
        if( totalWeight > 10 && totalWeight <= 17){
            totalSurcharge = new BigDecimal("8.50");
        } else if (totalWeight > 17 && totalWeight <= 25 ){
            totalSurcharge = new BigDecimal("12.50");
        } else if (totalWeight > 25 && totalWeight <= 35){
            totalSurcharge = new BigDecimal("19.99");
        } else if (totalWeight > 35){
            totalSurcharge = new BigDecimal("50.00");
        } else {
            totalSurcharge = new BigDecimal("0.00");
        }

        invoice.setSurcharge(totalSurcharge);
        totalCost = totalCost.add(totalSurcharge);

        float taxRate = 0.072f;
        invoice.setTax((totalCost.multiply(new BigDecimal(taxRate))).setScale(2, BigDecimal.ROUND_HALF_UP));
        totalCost = totalCost.add(invoice.getTax());

        invoice.setTotal(totalCost);

        invoice = shippingClient.addInvoice(invoice);

        return buildInvoiceViewModel(invoice);
    }
    public List<InvoiceViewModel> findInvoicesByCustomerId(int id){
        List<InvoiceViewModel> ivms = new ArrayList<>();
        List<Invoice> invoices =
        shippingClient.getAllInvoices().stream().filter(invoice -> invoice.getCustomerId() == id).collect(Collectors.toList());
        invoices.forEach(invoice -> {
            ivms.add(buildInvoiceViewModel(invoice));
        });
        return ivms;
    }
}

