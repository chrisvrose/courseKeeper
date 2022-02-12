package me.kekvrose.courseKeeper.chapter;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.kekvrose.courseKeeper.chapter.dto.ChapterInputDTO;
import me.kekvrose.courseKeeper.course.dto.CourseInputDTO;
import me.kekvrose.courseKeeper.utility.ResponseWrapper;

@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired ChapterService chapterService;

    @GetMapping
    public ResponseWrapper< List<Chapter>> getAll(){
        return new ResponseWrapper<>( chapterService.getAll());
    }

    @PostMapping
    public ResponseWrapper<Chapter> insert(@RequestBody ChapterInputDTO dto){
        return new ResponseWrapper<>(chapterService.insert(dto));
    }
    @PutMapping("/{id}/add")
    public ResponseWrapper<Void> insertCourse(@PathVariable("id") int id,@RequestBody CourseInputDTO dto) throws NotFoundException{
        chapterService.editAddCourse(id, dto);
        return new ResponseWrapper<>();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseWrapper<String> notfound(){
        return new ResponseWrapper<String>(false, "Not found");
    }
}
