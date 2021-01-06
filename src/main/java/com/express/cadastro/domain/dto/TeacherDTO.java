package com.express.cadastro.domain.dto;

import com.express.cadastro.domain.AddressEntity;
import com.express.cadastro.domain.BankInfoEntity;
import com.express.cadastro.domain.TeacherEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Data
public class TeacherDTO {

    private Long id;

    @NotBlank
    private String name;

    private String document;

    private String email;

    private BankInfoDTO bankInfo;

    private AddressDTO address;

    public static TeacherDTO toDto(TeacherEntity entity) {
        TeacherDTO teacherDTO = new TeacherDTO();

        if(Objects.nonNull(entity.getBankInfo())) {
            BankInfoDTO bankInfoDTO = BankInfoDTO.toDto(entity.getBankInfo());
            teacherDTO.setBankInfo(bankInfoDTO);
        }

        if(Objects.nonNull(entity.getAddress())) {
            AddressDTO addressDTO = AddressDTO.toDto(entity.getAddress());
            teacherDTO.setAddress(addressDTO);
        }

        teacherDTO.setId(entity.getId());
        teacherDTO.setName(entity.getName());
        teacherDTO.setDocument(entity.getDocument());
        teacherDTO.setEmail(entity.getEmail());

        return teacherDTO;
    }

    public TeacherEntity toEntity() {
        TeacherEntity teacher = new TeacherEntity();

        if(Objects.nonNull(this.getAddress())) {
            AddressEntity address = AddressDTO.toEntity(this.getAddress());
            teacher.setAddress(address);
        }

        if(Objects.nonNull(this.getBankInfo())) {
            BankInfoEntity bankInfo = BankInfoDTO.toEntity(this.getBankInfo());
            teacher.setBankInfo(bankInfo);
        }

        teacher.setName(this.getName());
        teacher.setDocument(this.getEmail());
        teacher.setEmail(this.getEmail());

        return teacher;
    }

}
