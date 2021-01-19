package com.express.cadastro.controller;

import com.express.cadastro.domain.dto.StudentDTO;
import com.express.cadastro.request.ClassroomRequest;
import com.express.cadastro.response.ClassroomResponse;
import com.express.cadastro.service.ClassroomService;
import com.express.cadastro.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("student")
public class ClassroomController {

    private final ClassroomService service;

    public ClassroomController(ClassroomService service) {
        this.service = service;
    }

    @GetMapping
    public Page<ClassroomResponse> findAll(@RequestParam(value = "teacherName", required = false) final String teacherName,
                                           @RequestParam(value = "courseLanguage", required = false) final String courseLanguage,
                                           @PageableDefault(sort = "id") final Pageable pageable) {
        return service.findAll(teacherName, courseLanguage, pageable);
    }

    @GetMapping("/{id}")
    public ClassroomResponse findOne(@PathVariable Long id) {
        return service.findOne(id);
    }

    @PostMapping
    public void create(@Valid @RequestBody ClassroomRequest request) {
        service.create(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ClassroomRequest request) {
        service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
