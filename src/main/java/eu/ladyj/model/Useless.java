package eu.ladyj.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USELESS")
public class Useless {
    private Integer id;
    private String message;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "message")
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
