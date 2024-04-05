package org.thelastride.thymeleaf.courses;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api")
public class controller {

    private final service service1;


    public controller(service service1) {
        this.service1 = service1;
    }

    @PostMapping("/save")
    public String save(@RequestBody model model1){

        model model2= service1.save(model1);
        System.out.println("Saved: "+ model2.getId());

        return "dropdown";
    }
    @GetMapping("/all")
    public String getAll(@RequestParam(name = "department", required = false) String selectedDepartment,@RequestParam(name = "name", required = false) String selectedName, Model model) {
        List<model> courses = service1.getAll();// Assuming your service method returns List<Model>
        courses=courses.stream().distinct().collect(Collectors.toList());
        model.addAttribute("courses", courses);
        model.addAttribute("selectedDepartment", selectedDepartment);
        model.addAttribute("selectedName",selectedName);
        service1.getAll();
        return "dropdown"; // Assuming "dropdown" is the name of your Thymeleaf template
    }


}
