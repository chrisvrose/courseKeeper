package me.kekvrose.courseKeeper.course;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Lob
    private byte[] contents;


    public Course() {
    }
    public Course(Integer id, String name, byte[] contents) {
        this.id = id;
        this.name = name;
        this.contents = contents;
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
    public byte[] getContents() {
        return contents;
    }
    public void setContents(byte[] contents) {
        this.contents = contents;
    }
}
