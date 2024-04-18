package org.thelastride.thymeleaf.lecturers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LecturerRepo extends JpaRepository<LecturerModel,String> {
    @Query("SELECT l FROM lecturer l JOIN FETCH l.programme")
    List<LecturerModel> findAllWithProgramme();
}
