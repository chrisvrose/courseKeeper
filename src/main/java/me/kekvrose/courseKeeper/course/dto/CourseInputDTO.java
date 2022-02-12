package me.kekvrose.courseKeeper.course.dto;


import me.kekvrose.courseKeeper.course.Course;

public class CourseInputDTO {
    private String name;
    
    private byte[] contents;

    public CourseInputDTO() {
    }

    public CourseInputDTO(String name, byte[] contents) {
        this.name = name;
        this.contents = contents;
    }

    public Course toCourse(){
        return new Course(null,name,contents);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContents() {
        return contents;
    }

    public void setContents(byte[] contents) {
        this.contents = contents;
    }
}
