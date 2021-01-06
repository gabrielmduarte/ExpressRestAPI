package com.express.cadastro.domain.dto;

import com.express.cadastro.domain.BankInfoEntity;
import com.express.cadastro.domain.enums.AccountType;
import lombok.Data;

@Data
public class BankInfoDTO {

    private String bankName;

    private String bankCode;

    private String accountNumber;

    private String agency;

    private AccountType accountType;

    public static BankInfoDTO toDto(BankInfoEntity bankInfo) {
        BankInfoDTO bankInfoDTO = new BankInfoDTO();
        bankInfoDTO.setBankName(bankInfo.getBankName());
        bankInfoDTO.setBankCode(bankInfo.getBankCode());
        bankInfoDTO.setAccountNumber(bankInfo.getAccountNumber());
        bankInfoDTO.setAgency(bankInfo.getAgency());
        bankInfoDTO.setAccountType(bankInfo.getAccountType());

        return bankInfoDTO;
    }

    public static BankInfoEntity toEntity(BankInfoDTO bankInfoDTO) {
        BankInfoEntity bankInfo = new BankInfoEntity();
        bankInfo.setBankName(bankInfoDTO.getBankName());
        bankInfo.setBankCode(bankInfoDTO.getBankCode());
        bankInfo.setAccountNumber(bankInfoDTO.getAccountNumber());
        bankInfo.setAgency(bankInfoDTO.getAgency());
        bankInfo.setAccountType(bankInfoDTO.getAccountType());

        return bankInfo;
    }
}
