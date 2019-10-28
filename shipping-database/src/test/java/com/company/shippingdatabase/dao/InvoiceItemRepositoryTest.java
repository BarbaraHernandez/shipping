package com.company.shippingdatabase.dao;

import com.company.shippingdatabase.model.InvoiceItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class InvoiceItemRepositoryTest {

    @Autowired
    private InvoiceItemRepository repo;

    @BeforeEach
    void setUp() {
        repo.deleteAll();
    }

    @Test
    void shouldAddandGetFromRepo(){
        InvoiceItem item1 = new InvoiceItem(
                1,
                "item",
                "good item",
                (float)20.20,
                new BigDecimal(5.00)
        );

        item1 = repo.save(item1);

        InvoiceItem checkItem = repo.getOne(item1.getItemId());

        assertEquals(item1, checkItem);
    }

    @Test
    void shouldGetAllFromRepo(){
        InvoiceItem item1 = new InvoiceItem(
                1,
                "item",
                "good item",
                (float)20.20,
                new BigDecimal(5.00)
        );
        InvoiceItem item2 = new InvoiceItem(
                1,
                "item2",
                "gooder item",
                (float)30.30,
                new BigDecimal(15.00)
        );
        item1 = repo.save(item1);
        item2 = repo.save(item2);

        List<InvoiceItem> expectedItems = new ArrayList<>();
        expectedItems.add(item1);
        expectedItems.add(item2);

        List<InvoiceItem> checkList = repo.findAll();

        assertEquals(expectedItems, checkList);
    }

    @Test
    void shouldNotReturnAfterDelete(){
        InvoiceItem item1 = new InvoiceItem(
                1,
                "item",
                "good item",
                (float)20.20,
                new BigDecimal(5.00)
        );
        InvoiceItem item2 = new InvoiceItem(
                1,
                "item2",
                "gooder item",
                (float)30.30,
                new BigDecimal(15.00)
        );
        item1 = repo.save(item1);
        item2 = repo.save(item2);
        List<InvoiceItem> expectedItems = new ArrayList<>();
        expectedItems.add(item1);

        repo.deleteById(item2.getItemId());

        List<InvoiceItem> checkList = repo.findAll();

        assertEquals(expectedItems, checkList);
    }
}