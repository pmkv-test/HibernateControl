package app.hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rhomb")
public class Rhomb extends Shape {

    @NotNull
    private Integer lenSaid;

    public Rhomb() {
    }

    public Rhomb(Integer lenSaid) {
        this.lenSaid = lenSaid;
    }

    public Integer getLenSaid() {
        return lenSaid;
    }

    public void setLenSaid(Integer lenSaid) {
        this.lenSaid = lenSaid;
    }
}
