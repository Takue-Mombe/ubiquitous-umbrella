package org.thelastride.thymeleaf.lecturers;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.thelastride.thymeleaf.courses.Programme;

@Entity(name="lecturer")
@Getter
@Setter
public class LecturerModel {

    @Id
    private String lecturerNumber;
    @Column
    private String name;
    @Column
    private String department;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programme_id")
    private Programme programme;



}
