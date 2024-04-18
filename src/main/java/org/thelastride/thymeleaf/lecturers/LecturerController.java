package org.thelastride.thymeleaf.lecturers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thelastride.thymeleaf.courses.Programme;
import org.thelastride.thymeleaf.courses.Programmerepo;
import org.thelastride.thymeleaf.courses.Programmeservice;

import java.util.List;

@Controller
@RequestMapping("/LecturerApi")
public class LecturerController {

    private final LecturerService lecturerService;
    private final Programmeservice programmeservice;
    private final Programmerepo programRepo;

    @Autowired
    public LecturerController(LecturerService lecturerService, Programmeservice programmeservice, Programmerepo programRepo) {
        this.lecturerService = lecturerService;
        this.programmeservice = programmeservice;
        this.programRepo = programRepo;
    }
    @PostMapping("/save")
    public String saveLecturer(@ModelAttribute LecturerModel lecturerModel,Long programId, Model model) {
        Programme programme = programRepo.findById(programId)
                .orElseThrow(() -> new IllegalArgumentException("Programme not found with id: " + programId));

        // Set the programme for the lecturer
        lecturerModel.setProgramme(programme);

        // Save the lecturer
        lecturerService.saveLecturer(lecturerModel);
        return "redirect:/list";
    }
    @GetMapping("/list")
    public String getAllLecturer(Model model) {
        List<LecturerModel> lecturers = lecturerService.getAll();
        List<Programme> programs = programmeservice.getAll();
        model.addAttribute("lecturers", lecturers);
        model.addAttribute("programs", programs);
        model.addAttribute("lecturerModel", new LecturerModel()); // Add empty lecturer model for form
        return "lecturers";
    }

}
