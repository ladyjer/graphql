package eu.ladyj.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "USELESS")
public class Useless {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "love",
            joinColumns = {@JoinColumn(name = "id_useless")},
            inverseJoinColumns = {@JoinColumn(name = "id_person")})
    private List<Person> lovedby = new ArrayList<>();

    @Id
    private Integer id;

    @Basic
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Useless useless = (Useless) o;
        return id == useless.id &&
                Objects.equals(message, useless.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message);
    }
}
