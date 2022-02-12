package me.kekvrose.courseKeeper.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.kekvrose.courseKeeper.course.dto.CourseInputDTO;
import me.kekvrose.courseKeeper.utility.ResponseWrapper;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseWrapper<List<Course>> getAll(){
        return new ResponseWrapper<>( courseService.getAll());
    }
    @GetMapping("{id}")
    public ResponseWrapper<Optional<Course>> getOne(@PathVariable int id){
        return new ResponseWrapper<Optional<Course>>(courseService.getOne(id));
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseWrapper<Course> addCourse(@RequestBody CourseInputDTO newCourse){
        return new ResponseWrapper<>(courseService.saveCourse(newCourse));
    }

    @PutMapping
    public ResponseWrapper<Course> addCourse(@RequestBody Course updated){
        return new ResponseWrapper<>(courseService.updateCourse(updated));
    }

    @DeleteMapping("{id}")
    public ResponseWrapper<Boolean> addCourse(@PathVariable int id){
        courseService.deleteCourse(id);
        return new ResponseWrapper<>(true);
    }

}
