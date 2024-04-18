package org.thelastride.thymeleaf.courses;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thelastride.thymeleaf.lecturers.LecturerService;

import java.util.List;

@Controller
@RequestMapping("/api")
public class programmeController {

    private final Programmeservice programmeservice1;
    @GetMapping("/addLecturer")
    public String showAddLecturerForm(Model model) {
        List<Programme> programs = programmeservice1.getAll();
        model.addAttribute("programs", programs);
        return "lecturers";
    }

    public programmeController(Programmeservice programmeservice1) {
        this.programmeservice1 = programmeservice1;
    }

@GetMapping("/list")
    public String getAll(Model model){
        List<Programme>programmes= programmeservice1.getAll();

        model.addAttribute("programmes",programmes);
        return "lecturers";
}


}
