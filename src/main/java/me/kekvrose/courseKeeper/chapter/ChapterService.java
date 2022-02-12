package me.kekvrose.courseKeeper.chapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import me.kekvrose.courseKeeper.chapter.dto.ChapterInputDTO;
import me.kekvrose.courseKeeper.course.Course;
import me.kekvrose.courseKeeper.course.CourseRepository;
import me.kekvrose.courseKeeper.course.dto.CourseInputDTO;

@Service
public class ChapterService {
    @Autowired
    ChapterRepository chapterRepository;
    @Autowired
    CourseRepository courseRepository;

    public List<Chapter> getAll() {
        return chapterRepository.findAll();
    }
    

    public Chapter insert(ChapterInputDTO c) {
        return chapterRepository.save(c.toChapter());
    }
    
    public void editAddCourse(int chapterId,CourseInputDTO dto) throws NotFoundException{
        Optional<?> chapterOptional = chapterRepository.findById(chapterId);
        if(!chapterOptional.isPresent()) throw new NotFoundException(); 
        Chapter chapter = (Chapter) chapterOptional.get();
        chapter.courses.add(dto.toCourse());
        chapterRepository.save(chapter);
    }

    public void editAddCourse(int chapterId,int courseId) throws NotFoundException {
        Optional<?> chapterOptional = chapterRepository.findById(chapterId);
        if(!chapterOptional.isPresent()) throw new NotFoundException(); 
        Optional<?> course = courseRepository.findById(courseId);

        if (!course.isPresent())
            throw new NotFoundException();
        Course c = (Course) course.get();
        Chapter chapter = (Chapter) chapterOptional.get();
        chapter.courses.add(c);
        chapterRepository.save(chapter);
    }

    
}
