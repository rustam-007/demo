package az.ingress.demo.controller;

import az.ingress.demo.model.Student;
import az.ingress.demo.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
//@RequiredArgsConstructor only final variables
@AllArgsConstructor
public class StudentController {

//    @Autowired
    private final ModelMapper modelMapper;
    private final StudentService studentService;

    @GetMapping
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentByid(id);
    }

    @PostMapping
    public String saveStudent(@RequestBody Student student) {
        StudentService studentService = modelMapper.map(student, StudentService);
        return "Student inserted to db with name: " + student.getName();
    }

    @PutMapping
    public Integer updateStudent (@RequestBody Student student) {
        student.setName("Kamil");
        System.out.println(student);
        return student.getId();
    }

    @DeleteMapping
    public String deleteStudent (@RequestParam(value = "id") int id) {
        return "Student with id: " + id + " was deleted";
    }
}
