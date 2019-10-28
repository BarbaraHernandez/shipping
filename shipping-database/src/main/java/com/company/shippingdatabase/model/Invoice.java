package com.company.shippingdatabase.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "invoice_id")
    private Integer id;
    @NotNull
    @Column(name = "customer_id")
    private Integer customerId;
    @NotNull
    @Column (name = "shipto_zip")
    @Size (max = 5)
    private String zip;
    @NotNull
    @Column(name = "total_cost")
    private BigDecimal total;
    @NotNull
    @Column(name = "sales_tax")
    private BigDecimal tax;
    @NotNull
    @Column(name = "surcharge")
    private BigDecimal surcharge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(BigDecimal surcharge) {
        this.surcharge = surcharge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(id, invoice.id) &&
                customerId.equals(invoice.customerId) &&
                zip.equals(invoice.zip) &&
                total.equals(invoice.total) &&
                tax.equals(invoice.tax) &&
                surcharge.equals(invoice.surcharge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, zip, total, tax, surcharge);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", zip='" + zip + '\'' +
                ", total=" + total +
                ", tax=" + tax +
                ", surcharge=" + surcharge +
                '}';
    }

    public Invoice(@NotNull Integer customerId, @NotNull @Size(max = 5) String zip, @NotNull BigDecimal total, @NotNull BigDecimal tax, @NotNull BigDecimal surcharge) {
        this.customerId = customerId;
        this.zip = zip;
        this.total = total;
        this.tax = tax;
        this.surcharge = surcharge;
    }

    public Invoice(Integer id, @NotNull Integer customerId, @NotNull @Size(max = 5) String zip, @NotNull BigDecimal total, @NotNull BigDecimal tax, @NotNull BigDecimal surcharge) {
        this.id = id;
        this.customerId = customerId;
        this.zip = zip;
        this.total = total;
        this.tax = tax;
        this.surcharge = surcharge;
    }

    public Invoice(){}
}
