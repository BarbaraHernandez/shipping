package com.company.shippingedge.models;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Invoice {
    private Integer id;
    private Integer customerId;
    @Size(max = 5)
    private String zip;
    private BigDecimal total;
    private BigDecimal tax;
    private BigDecimal surcharge;

    public Invoice(Integer id, Integer customerId, @Size(max = 5) String zip, BigDecimal total, BigDecimal tax, BigDecimal surcharge) {
        this.id = id;
        this.customerId = customerId;
        this.zip = zip;
        this.total = total;
        this.tax = tax;
        this.surcharge = surcharge;
    }

    public Invoice(Integer customerId, @Size(max = 5) String zip, BigDecimal total, BigDecimal tax, BigDecimal surcharge) {
        this.customerId = customerId;
        this.zip = zip;
        this.total = total;
        this.tax = tax;
        this.surcharge = surcharge;
    }

    public Invoice() {
    }

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
                Objects.equals(total, invoice.total) &&
                Objects.equals(tax, invoice.tax) &&
                Objects.equals(surcharge, invoice.surcharge);
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
}
