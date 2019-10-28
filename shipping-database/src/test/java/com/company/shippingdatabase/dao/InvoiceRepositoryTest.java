package com.company.shippingdatabase.dao;

import com.company.shippingdatabase.model.InvoiceItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

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
    void shouldAddAndGetFromRepo(){


    }
}