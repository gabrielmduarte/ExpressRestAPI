package com.express.cadastro.response;

import com.express.cadastro.domain.ClassroomEntity;
import com.express.cadastro.domain.dto.CourseDTO;
import com.express.cadastro.domain.dto.StudentDTO;
import com.express.cadastro.domain.dto.TeacherDTO;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ClassroomResponse {

    private TeacherDTO teacher;

    private CourseDTO course;

    private List<StudentDTO> studentsEnrolled;

    public static ClassroomResponse toResponse(ClassroomEntity entity) {
        TeacherDTO teacherDTO = TeacherDTO.toDto(entity.getTeacher());
        CourseDTO courseDTO = CourseDTO.toDTO(entity.getCourse());
        List<StudentDTO> studentDTOList = entity.getStudentsEnrolled()
                                                    .stream()
                                                    .map(StudentDTO::toDto)
                                                    .collect(Collectors.toList());

        ClassroomResponse classroomResponse = new ClassroomResponse();
        classroomResponse.setTeacher(teacherDTO);
        classroomResponse.setCourse(courseDTO);
        classroomResponse.setStudentsEnrolled(studentDTOList);

        return classroomResponse;
    }

}
