package edu.ntudp.polisnichenko.models;

public abstract class BaseEntity {
    private String name;
    private Head head;

    public BaseEntity(String name, Head head) {
        this.name = name;
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }
}
