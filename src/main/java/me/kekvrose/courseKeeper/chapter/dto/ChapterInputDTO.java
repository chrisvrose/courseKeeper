package me.kekvrose.courseKeeper.chapter.dto;

import java.util.List;
import java.util.stream.Collectors;

import me.kekvrose.courseKeeper.chapter.Chapter;
import me.kekvrose.courseKeeper.course.dto.CourseInputDTO;


public class ChapterInputDTO {
    
    String name;

    List<CourseInputDTO> courses;

    public Chapter toChapter(){
        return new Chapter(null,name,courses.stream().map(e->e.toCourse()).collect(Collectors.toList()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseInputDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseInputDTO> courses) {
        this.courses = courses;
    }
}
