package com.partslistM.entity;
import javax.persistence.*;

@Entity
@Table(name ="part", schema = "test",catalog = "")
public class PartsList {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "Name_item")
    private String name;

    @Column(name = "Needs")
    private boolean need;

    @Column(name = "Quantity")
    private int quantity;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getNeed() {
        return need;
    }

    public void setNeed(boolean need) {
        this.need = need;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public PartsList(String name, boolean need, int quantity) {
        this.name = name;
        this.need = need;
        this.quantity = quantity;
    }

    public PartsList(){

    }
}
