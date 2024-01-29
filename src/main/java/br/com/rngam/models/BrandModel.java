package br.com.rngam.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity(name = "TB_BRAND")
public class BrandModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_sq")
    @SequenceGenerator(name = "brand_sq", sequenceName = "sq_brand", initialValue = 1)
    private long id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "description", length = 200, nullable = false)
    private String description;
    @Column(name = "since", length = 4, nullable = true)
    private Integer since;
    @OneToMany(mappedBy = "carBrand")
    private List<CarModel> carList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSince() {
        return since;
    }

    public void setSince(Integer since) {
        this.since = since;
    }

    public List<CarModel> getCarList() {
        return carList;
    }

    public void setCarList(List<CarModel> carList) {
        this.carList = carList;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        BrandModel that = (BrandModel) object;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(since, that.since);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, since, carList);
    }
}
