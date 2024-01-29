package br.com.rngam.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_CAR")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_license_sq")
    @SequenceGenerator(name = "car_license_sq", sequenceName = "sq_car", initialValue = 1)
    private Integer licensePlate;
    @Column(name = "type",  length = 50, nullable = false)
    private String type;
    @OneToMany(mappedBy = "car")
    private List<AccessoryModel> acessories;
    @ManyToOne
    @JoinColumn(name = "id_accessory_fk",
            foreignKey = @ForeignKey(name = "fk_car_accessory"),
            referencedColumnName = "id", nullable = false
    )
    private BrandModel carBrand;

    public Integer getLicencePlate() {
        return licensePlate;
    }

    public void setLicencePlate(Integer licensePlate) {
        this.licensePlate = licensePlate;
    }


    public Integer getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(Integer licensePlate) {
        this.licensePlate = licensePlate;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BrandModel getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(BrandModel carBrand) {
        this.carBrand = carBrand;
    }

    public List<AccessoryModel> getAcessories() {
        return acessories;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CarModel carModel = (CarModel) object;
        return Objects.equals(licensePlate, carModel.licensePlate) && Objects.equals(type, carModel.type) && Objects.equals(carBrand, carModel.carBrand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate, type, acessories, carBrand);
    }

    public void setAcessories(List<AccessoryModel> acessories) {
        this.acessories = acessories;
    }
}
