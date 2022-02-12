package me.kekvrose.courseKeeper.chapter;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import me.kekvrose.courseKeeper.course.Course;

@Entity
public class Chapter {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="course_fk_col")
    List<Course> courses;
    @Id
    @GeneratedValue
    Integer id;
    @Column(nullable = false,unique = true)
    String name;


    


    public Chapter( Integer id, String name,List<Course> courses) {
        this.courses = courses;
        this.id = id;
        this.name = name;
    }
    public Chapter() {
    }
    public List<Course> getCourses() {
        return courses;
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
