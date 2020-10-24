package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Invoice invoice = new Invoice("1/01/2020");
        Invoice invoice2 = new Invoice("2/04/2020");

        Product apple = new Product("Apple");
        Product orange = new Product("Orange");
        Product banana = new Product("Banana");

        Item position1 = new Item(new BigDecimal("10"), new BigDecimal("1.90"));
        Item position2 = new Item(new BigDecimal("5"), new BigDecimal("2.40"));
        Item position3 = new Item(new BigDecimal("3"), new BigDecimal("4.90"));

        invoice.getItems().add(position1);
        invoice.getItems().add(position2);
        invoice2.getItems().add(position3);

        position1.setProduct(apple);
        position2.setProduct(orange);
        position3.setProduct(banana);

        //When
        invoiceDao.save(invoice);
        int invoiceOneId = invoice.getId();
        invoiceDao.save(invoice2);
        int invoiceTwoId = invoice.getId();
        int positionOneId = position1.getId();
        int positionTwoId = position1.getId();
        int positionThreeId = position1.getId();
        int appleId = position1.getId();
        int orangeId = position1.getId();
        int bananaId = position1.getId();

        //Then
        Assertions.assertNotEquals(0, invoiceOneId);
        Assertions.assertNotEquals(0, invoiceTwoId);
        Assertions.assertNotEquals(0, positionOneId);
        Assertions.assertNotEquals(0, positionTwoId);
        Assertions.assertNotEquals(0, positionThreeId);
        Assertions.assertNotEquals(0, appleId);
        Assertions.assertNotEquals(0, orangeId);
        Assertions.assertNotEquals(0, bananaId);

        //Clean up
        try {
            invoiceDao.deleteById(invoiceOneId);
            invoiceDao.deleteById(invoiceTwoId);
        } catch (Exception e) {
            //do nothing
        }
    }

}
