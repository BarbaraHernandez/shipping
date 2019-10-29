package com.company.shippingedge.service;

import com.company.shippingedge.feign.ShippingClient;
import com.company.shippingedge.models.Invoice;
import com.company.shippingedge.models.InvoiceItem;
import com.company.shippingedge.models.viewmodels.InvoiceViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ServiceLayerTest {
    private ShippingClient shippingClient;
    private ServiceLayer serviceLayer;

    private void setUpShippingClientMock(){
        shippingClient = mock(ShippingClient.class);

        Invoice invoice = new Invoice(1, 1, "11111", new BigDecimal("75.02"), new BigDecimal("5.04"), new BigDecimal("50.00"));
        Invoice invoiceInput = new Invoice( 1, "11111", new BigDecimal("75.02"), new BigDecimal("5.04"), new BigDecimal("50.00"));
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);

        InvoiceItem invoiceItem = new InvoiceItem(1,1, "itemName", "itemDescription", (float) 10.00, new BigDecimal("9.99"));
        InvoiceItem invoiceItem1 = new InvoiceItem(2, 1, "itemName2", "itemDescription2", (float) 40.00, new BigDecimal("9.99"));
        InvoiceItem invoiceItemInput = new InvoiceItem(1, "itemName", "itemDescription", (float) 10.00, new BigDecimal("9.99"));
        InvoiceItem invoiceItem1Input = new InvoiceItem( 1, "itemName2", "itemDescription2", (float) 40.00, new BigDecimal("9.99"));
        List<InvoiceItem> invoiceItems = new ArrayList<>();
        invoiceItems.add(invoiceItem);
        invoiceItems.add(invoiceItem1);

        doReturn(invoice).when(shippingClient).addInvoice(invoiceInput);
        doReturn(invoice).when(shippingClient).getInvoice(1);
        doReturn(invoices).when(shippingClient).getAllInvoices();

        doReturn(invoiceItem).when(shippingClient).addInvoiceItem(invoiceItemInput);
        doReturn(invoiceItem1).when(shippingClient).addInvoiceItem(invoiceItem1Input);
        doReturn(invoiceItem).when(shippingClient).getInvoiceItem(1);
        doReturn(invoiceItem1).when(shippingClient).getInvoiceItem(2);
        doReturn(invoiceItems).when(shippingClient).getAllInvoiceItems();
    }

    @BeforeEach
    void setUp() {
        setUpShippingClientMock();
        serviceLayer = new ServiceLayer(shippingClient);
    }

    @Test
    void buildInvoiceViewModel() {
        Invoice invoice = new Invoice(1, 1, "11111", new BigDecimal("100.00"), new BigDecimal("7.20"), new BigDecimal("50.00"));

        InvoiceItem invoiceItem = new InvoiceItem(1,1, "itemName", "itemDescription", (float) 10.00, new BigDecimal("9.99"));
        InvoiceItem invoiceItem1 = new InvoiceItem(2, 1, "itemName2", "itemDescription2", (float) 40.00, new BigDecimal("9.99"));
        List<InvoiceItem> invoiceItems = new ArrayList<>();
        invoiceItems.add(invoiceItem);
        invoiceItems.add(invoiceItem1);

        InvoiceViewModel ivm = new InvoiceViewModel(1, 1,"11111", new BigDecimal("100.00"), new BigDecimal("7.20"), new BigDecimal("50.00"), invoiceItems);

        assertEquals(ivm, serviceLayer.buildInvoiceViewModel(invoice));
    }

    @Test
    void addInvoice() {
        InvoiceItem invoiceItem = new InvoiceItem(1,1, "itemName", "itemDescription", (float) 10.00, new BigDecimal("9.99"));
        InvoiceItem invoiceItem1 = new InvoiceItem(2, 1, "itemName2", "itemDescription2", (float) 40.00, new BigDecimal("9.99"));
        List<InvoiceItem> invoiceItems = new ArrayList<>();
        invoiceItems.add(invoiceItem);
        invoiceItems.add(invoiceItem1);

        InvoiceViewModel ivm = new InvoiceViewModel(1, "11111", invoiceItems);
        InvoiceViewModel expectedIvm = new InvoiceViewModel(1, 1,"11111", new BigDecimal("75.02"), new BigDecimal("5.04"), new BigDecimal("50.00"), invoiceItems);

        assertEquals(expectedIvm, serviceLayer.addInvoice(ivm));
    }

    @Test
    void findInvoicesByCustomerId() {
        InvoiceItem invoiceItem = new InvoiceItem(1,1, "itemName", "itemDescription", (float) 10.00, new BigDecimal("9.99"));
        InvoiceItem invoiceItem1 = new InvoiceItem(2, 1, "itemName2", "itemDescription2", (float) 40.00, new BigDecimal("9.99"));
        List<InvoiceItem> invoiceItems = new ArrayList<>();
        invoiceItems.add(invoiceItem);
        invoiceItems.add(invoiceItem1);
        InvoiceViewModel expectedIvm = new InvoiceViewModel(1, 1,"11111", new BigDecimal("75.02"), new BigDecimal("5.04"), new BigDecimal("50.00"), invoiceItems);

        assertEquals(1, serviceLayer.findInvoicesByCustomerId(1).size());
    }
}