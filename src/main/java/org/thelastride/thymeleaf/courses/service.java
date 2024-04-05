package org.thelastride.thymeleaf.courses;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class service {

    private final repo repo1;

    public service(org.thelastride.thymeleaf.courses.repo repo) {
        this.repo1 = repo;
    }
    public model save(model model1){
        return repo1.save(model1);
    }
    public List<model>getAll(){
        return repo1.findAll();
    }


    public Optional<model> getByDepartment(String department){
        return repo1.findByDepartment(department);
    }
}
