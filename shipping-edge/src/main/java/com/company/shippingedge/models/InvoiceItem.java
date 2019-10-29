package com.company.shippingedge.models;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceItem {
    private Integer itemId;
    private Integer invoiceId;
    @Size(max = 50)
    private String name;
    @Size(max = 255)
    private String description;
    private float weight;
    private BigDecimal shipCost;

    public InvoiceItem(Integer itemId, Integer invoiceId, @Size(max = 50) String name, @Size(max = 255) String description, float weight, BigDecimal shipCost) {
        this.itemId = itemId;
        this.invoiceId = invoiceId;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.shipCost = shipCost;
    }

    public InvoiceItem(Integer invoiceId, @Size(max = 50) String name, @Size(max = 255) String description, float weight, BigDecimal shipCost) {
        this.invoiceId = invoiceId;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.shipCost = shipCost;
    }

    public InvoiceItem() {
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public BigDecimal getShipCost() {
        return shipCost;
    }

    public void setShipCost(BigDecimal shipCost) {
        this.shipCost = shipCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItem that = (InvoiceItem) o;
        return Float.compare(that.weight, weight) == 0 &&
                Objects.equals(itemId, that.itemId) &&
                Objects.equals(invoiceId, that.invoiceId) &&
                name.equals(that.name) &&
                description.equals(that.description) &&
                Objects.equals(shipCost, that.shipCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, invoiceId, name, description, weight, shipCost);
    }

    @Override
    public String toString() {
        return "InvoiceItem{" +
                "itemId=" + itemId +
                ", invoiceId=" + invoiceId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", shipCost=" + shipCost +
                '}';
    }
}
