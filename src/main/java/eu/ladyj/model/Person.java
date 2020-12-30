package eu.ladyj.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PERSON")
public class Person {
    private Integer id;
    private String name;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String message) {
        this.name = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person useless = (Person) o;
        return id == useless.id &&
                Objects.equals(name, useless.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
