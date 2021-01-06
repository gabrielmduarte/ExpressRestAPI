package com.express.cadastro.domain.dto;

import com.express.cadastro.domain.StudentEntity;
import lombok.Data;

@Data
public class StudentDTO {

    private Long id;

    private String name;

    private String phone;

    private String email;

    public static StudentDTO toDto(StudentEntity entity) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(entity.getId());
        studentDTO.setName(entity.getName());
        studentDTO.setPhone(entity.getPhone());
        studentDTO.setEmail(entity.getEmail());

        return studentDTO;
    }

    public static StudentEntity toEntity(StudentDTO dto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(dto.getName());
        studentEntity.setPhone(dto.getPhone());
        studentEntity.setEmail(dto.getEmail());

        return studentEntity;
    }

}
