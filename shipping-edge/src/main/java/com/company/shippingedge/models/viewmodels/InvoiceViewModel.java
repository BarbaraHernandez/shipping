package com.company.shippingedge.models.viewmodels;

import com.company.shippingedge.models.InvoiceItem;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class InvoiceViewModel {
    private Integer id;
    private Integer customerId;
    @Size(max = 5)
    private String zip;
    private BigDecimal total;
    private BigDecimal tax;
    private BigDecimal surcharge;
    private List<InvoiceItem> items;

    public InvoiceViewModel(Integer id, Integer customerId, @Size(max = 5) String zip, BigDecimal total, BigDecimal tax, BigDecimal surcharge, List<InvoiceItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.zip = zip;
        this.total = total;
        this.tax = tax;
        this.surcharge = surcharge;
        this.items = items;
    }

    public InvoiceViewModel(Integer customerId, @Size(max = 5) String zip, List<InvoiceItem> items) {
        this.customerId = customerId;
        this.zip = zip;
        this.items = items;
    }

    public InvoiceViewModel() {
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

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return Objects.equals(id, that.id) &&
                customerId.equals(that.customerId) &&
                zip.equals(that.zip) &&
                Objects.equals(total, that.total) &&
                Objects.equals(tax, that.tax) &&
                Objects.equals(surcharge, that.surcharge) &&
                items.equals(that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, zip, total, tax, surcharge, items);
    }

    @Override
    public String toString() {
        return "InvoiceViewModel{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", zip='" + zip + '\'' +
                ", total=" + total +
                ", tax=" + tax +
                ", surcharge=" + surcharge +
                ", items=" + items +
                '}';
    }
}
