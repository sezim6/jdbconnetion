package org.example;

public class President {
    private Long id;
    private String name;
    private String lastname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public President( String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public President() {
    }

    @Override
    public String toString() {
        return "President " +
                "id : " + id +
                "name : " + name + '\'' +
                "lastname : " + lastname + '\'' ;
    }
}
