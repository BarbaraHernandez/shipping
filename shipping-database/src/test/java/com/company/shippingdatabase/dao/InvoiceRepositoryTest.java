package com.company.shippingdatabase.dao;

import com.company.shippingdatabase.model.Invoice;
import com.company.shippingdatabase.model.InvoiceItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class InvoiceRepositoryTest {

    @Autowired
    private InvoiceRepository repo;

    @BeforeEach
    void setUp() {
        repo.deleteAll();
    }

    @Test
    void shouldAddandGetFromRepo(){
        Invoice inv1 = new Invoice(
                1,
                "10101",
                LocalDate.of(2000,01,01),
                new BigDecimal("50.50"),
                new BigDecimal("2.50"),
                new BigDecimal("5.50")
        );

        inv1 = repo.save(inv1);

        Invoice checkInvoice = repo.getOne(inv1.getId());

        assertEquals(inv1, checkInvoice);
    }

    @Test
    void shouldGetAllFromRepo(){
        Invoice inv1 = new Invoice(
                1,
                "10101",
                LocalDate.of(2000,01,01),
                new BigDecimal("50.50"),
                new BigDecimal("2.50"),
                new BigDecimal("5.50")
        );
        Invoice inv2 = new Invoice(
                2,
                "10201",
                LocalDate.of(2000,02,02),
                new BigDecimal(50.50),
                new BigDecimal(2.50),
                new BigDecimal(5.50)
        );
        inv1 = repo.save(inv1);
        inv2 = repo.save(inv2);

        List<Invoice> expectedInvoices = new ArrayList<>();
        expectedInvoices.add(inv1);
        expectedInvoices.add(inv2);

        List<Invoice> checkList = repo.findAll();

        assertEquals(expectedInvoices, checkList);
    }

    @Test
    void shouldNotReturnAfterDelete(){
        Invoice inv1 = new Invoice(
                1,
                "10101",
                LocalDate.of(2000,01,01),
                new BigDecimal("50.50"),
                new BigDecimal("2.50"),
                new BigDecimal("5.50")
        );
        Invoice inv2 = new Invoice(
                2,
                "10201",
                LocalDate.of(2000,02,02),
                new BigDecimal("50.50"),
                new BigDecimal("2.50"),
                new BigDecimal("5.50")
        );
        inv1 = repo.save(inv1);
        inv2 = repo.save(inv2);
        List<Invoice> expectedInvoices = new ArrayList<>();
        expectedInvoices.add(inv1);

        repo.deleteById(inv2.getId());

        List<Invoice> checkList = repo.findAll();

        assertEquals(expectedInvoices, checkList);
    }
}