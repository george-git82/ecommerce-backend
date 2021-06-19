package com.abhishek.productinventory.inventory;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Inventory {
    @Id
    String id;
    String qty;

    public Inventory() {
    }

    public Inventory(String id, String qty) {
        this.id = id;
        this.qty = qty;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQty() {
        return this.qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", qty='" + getQty() + "'" + "}";
    }

}
