package app.hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "circle")
public class Circle extends Shape {

    @NotNull
    private Integer radius;

    public Circle() {
    }

    public Circle(Integer radius) {
        this.radius = radius;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        radius = radius;
    }

}
