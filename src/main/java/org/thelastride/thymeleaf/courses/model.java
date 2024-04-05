package org.thelastride.thymeleaf.courses;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;

@Entity(name = "programme")

public class model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;
    @Column(name = "department")
    public String department;

    @Column(name = "description")
    public String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
