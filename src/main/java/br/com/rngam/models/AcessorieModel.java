package br.com.rngam.models;

import jakarta.persistence.*;

@Entity(name = "TB_ACESSORIE")
public class AcessorieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorie_id_sq")
    @SequenceGenerator(name = "acessorie_id_sq", sequenceName = "sq_acessorie", initialValue = 1)
    private long id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "description", length = 200, nullable = true)
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_acessorie_fk",
            foreignKey = @ForeignKey(name = "fk_acessorie_car"),
            referencedColumnName = "licenseplate", nullable = false
    )
    CarModel car;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CarModel getCar() {
        return car;
    }

    public void setCar(CarModel car) {
        this.car = car;
    }
}
