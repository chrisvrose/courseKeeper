package me.kekvrose.courseKeeper.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.kekvrose.courseKeeper.course.dto.CourseInputDTO;

@Service
public class CourseService {
    // private List<Course> fakeList = new ArrayList<Course>(Arrays.asList(new Course(1,"hi",new byte[]{})));

    @Autowired private CourseRepository courseRepository;

    public List<Course> getAll(){
        // return fakeList;
        return courseRepository.findAll();
    }

    public Optional<Course> getOne(int id){
        Optional<Course> c = courseRepository.findById(id);
        return c;    
    }
    public Course saveCourse(CourseInputDTO dto){
        return courseRepository.save(dto.toCourse());
    }
    public Course updateCourse(Course course){
        return courseRepository.save(course);
    }

    public void deleteCourse(int id){
        courseRepository.deleteById(id);
    }
}
