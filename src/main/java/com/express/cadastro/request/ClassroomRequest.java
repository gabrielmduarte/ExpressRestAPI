package com.express.cadastro.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ClassroomRequest {

    @NotNull
    private Long teacherId;

    @NotNull
    private Long courseId;

    private List<Long> studentsId;

}
