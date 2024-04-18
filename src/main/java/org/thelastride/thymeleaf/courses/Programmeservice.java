package org.thelastride.thymeleaf.courses;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Programmeservice {

    private final Programmerepo repo1;

    public Programmeservice(Programmerepo repo) {
        this.repo1 = repo;
    }
    public Programme save(Programme model1){
        return repo1.save(model1);
    }
    public List<Programme>getAll(){
        return repo1.findAll();
    }

    public Optional<Programme> getByDepartment(String department){
        return repo1.findByDepartment(department);
    }
}
