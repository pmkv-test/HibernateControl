package app.hibernate;

import javax.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "shape")
public class Shape {

    @Id
    @GeneratedValue()
    private Integer Id;

    public Shape() {
    }

    @OneToOne
    private ShapeColor shapeColor;

    public ShapeColor getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(ShapeColor shapeColor) {
        this.shapeColor = shapeColor;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

}
