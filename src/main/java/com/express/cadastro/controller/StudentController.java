package com.express.cadastro.controller;

import com.express.cadastro.domain.dto.StudentDTO;
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
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public Page<StudentDTO> findAll(@RequestParam(value = "name", required = false) final String name,
                                    @RequestParam(value = "email", required = false) final String email,
                                    @PageableDefault(sort = "id") final Pageable pageable) {
        return service.findAll(name, email, pageable);
    }

    @GetMapping("/{id}")
    public StudentDTO findOne(@PathVariable Long id) {
        return service.findOne(id);
    }

    @PostMapping
    public void create(@Valid @RequestBody StudentDTO dto) {
        service.create(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody StudentDTO dto) {
        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
