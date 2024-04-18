package org.thelastride.thymeleaf.lecturers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerService {

    private final LecturerRepo lecturerRepo;

    @Autowired
    public LecturerService(LecturerRepo lecturerRepo) {
        this.lecturerRepo = lecturerRepo;
    }

    public LecturerModel saveLecturer(LecturerModel lecturerModel){
        return lecturerRepo.save(lecturerModel);
    }
    public List<LecturerModel> getAll() {
        return lecturerRepo.findAllWithProgramme();
    }


}
