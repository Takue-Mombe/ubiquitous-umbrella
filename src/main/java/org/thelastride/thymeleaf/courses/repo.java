package org.thelastride.thymeleaf.courses;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface repo extends JpaRepository<model,Long> {
    Optional<model> findByDepartment(String  department);
}
