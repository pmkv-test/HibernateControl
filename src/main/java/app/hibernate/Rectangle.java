package app.hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rectangle")
public class Rectangle extends Shape {

    @NotNull
    private Integer height;

    @NotNull
    private Integer width;

    public Rectangle(Integer height, Integer width) {
        this.height = height;
        this.width = width;
    }

    public Rectangle() {
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

}
