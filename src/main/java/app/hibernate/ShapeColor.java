package app.hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "color")
public class ShapeColor {

    public ShapeColor() {
    }

    public ShapeColor(String nameColor, String rgbCode) {
        this.nameColor = nameColor;
        this.rgbCode = rgbCode;
    }

    @Id
    @GeneratedValue()
    private Integer Id;

    @Column(length = 255)
    @NotNull
    private String nameColor;

    @Column(length = 255)
    @NotNull
    private String rgbCode;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNameColor() {
        return nameColor;
    }

    public void setNameColor(String nameColor) {
        this.nameColor = nameColor;
    }

    public String getRgbCode() {
        return rgbCode;
    }

    public void setRgbCode(String rgbCode) {
        this.rgbCode = rgbCode;
    }
}
