package br.com.rngam.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_CAR")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_license_sq")
    @SequenceGenerator(name = "car_license_sq", sequenceName = "sq_car", initialValue = 1)
    private Integer licensePlate;
    @Column(name = "brand", length = 50, nullable = false)
    private String brand;
    @Column(name = "type",  length = 50, nullable = false)
    private String type;
    @OneToMany(mappedBy = "car")
    private List<acessorieModel> acessories;
    @ManyToOne
    @JoinColumn(name = "id_car_fk",
            foreignKey = @ForeignKey(name = "fk_car_description"),
            referencedColumnName = "id", nullable = false
    )
    private BrandModel carBrand;

    public Integer getLicencePlate() {
        return licensePlate;
    }

    public void setLicencePlate(Integer licensePlate) {
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

    public List<acessorieModel> getAcessories() {
        return acessories;
    }

    public void setAcessories(List<acessorieModel> acessories) {
        this.acessories = acessories;
    }
}
