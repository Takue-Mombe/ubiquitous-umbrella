package org.thelastride.thymeleaf.courses;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.thelastride.thymeleaf.lecturers.LecturerModel;

@Entity(name = "programme")
@Getter@Setter
public class Programme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;
    @Column(name = "department")
    public String department;

    @Column(name = "description")
    public String description;
    @OneToOne(mappedBy = "programme", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private LecturerModel lecturer;
}
