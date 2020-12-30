package eu.ladyj.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    private Integer id;

    @Basic
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "love",
            joinColumns = {@JoinColumn(name = "id_person")},
            inverseJoinColumns = {@JoinColumn(name = "id_useless")})
    public Set<Useless> loves;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
