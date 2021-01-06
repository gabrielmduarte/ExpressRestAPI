package com.express.cadastro.domain.dto;

import com.express.cadastro.domain.CourseEntity;
import com.express.cadastro.domain.enums.Level;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CourseDTO {

    private Long id;

    private String language;

    private Level level;

    private BigDecimal monthlyFee;

    public static CourseDTO toDTO(CourseEntity entity) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(entity.getId());
        courseDTO.setLanguage(entity.getLanguage());
        courseDTO.setLevel(entity.getLevel());
        courseDTO.setMonthlyFee(entity.getMonthlyFee());

        return courseDTO;
    }

    public static CourseEntity toEntity(CourseDTO dto) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setLanguage(dto.getLanguage());
        courseEntity.setLevel(dto.getLevel());
        courseEntity.setMonthlyFee(dto.getMonthlyFee());

        return courseEntity;
    }

}
