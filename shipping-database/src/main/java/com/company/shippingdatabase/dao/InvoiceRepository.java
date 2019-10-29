package com.company.shippingdatabase.dao;

import com.company.shippingdatabase.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
