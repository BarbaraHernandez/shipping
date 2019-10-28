package com.company.shippingdatabase.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "invoice_item")
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "invoice_item_id")
    private Integer itemId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id")
    private Integer invoiceId;
    @NotNull
    @Column(name = "item_name")
    @Size(max = 50)
    private String name;
    @NotNull
    @Column(name = "item_description")
    @Size(max = 255)
    private String description;
    @NotNull
    @Column(name = "weight")
    private float weight;
    @NotNull
    @Column(name = "ship_cost")
    @Digits(integer=7,fraction=2)
    private BigDecimal shipCost;

    public InvoiceItem(Integer itemId, Integer invoiceId, @NotNull @Size(max = 50) String name, @NotNull @Size(max = 255) String description, @NotNull float weight, @NotNull @Digits(integer = 7, fraction = 2) BigDecimal shipCost) {
        this.itemId = itemId;
        this.invoiceId = invoiceId;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.shipCost = shipCost;
    }

    public InvoiceItem(Integer invoiceId, @NotNull @Size(max = 50) String name, @NotNull @Size(max = 255) String description, @NotNull float weight, @NotNull @Digits(integer = 7, fraction = 2) BigDecimal shipCost) {
        this.invoiceId = invoiceId;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.shipCost = shipCost;
    }

    public InvoiceItem(){}

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItem that = (InvoiceItem) o;
        return Float.compare(that.weight, weight) == 0 &&
                Objects.equals(itemId, that.itemId) &&
                invoiceId.equals(that.invoiceId) &&
                name.equals(that.name) &&
                description.equals(that.description) &&
                shipCost.equals(that.shipCost);
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
