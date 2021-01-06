package com.express.cadastro.domain.dto;

import com.express.cadastro.domain.AddressEntity;
import lombok.Data;

@Data
public class AddressDTO {

    private String address;

    private String city;

    private String state;

    private String country;

    private String postalCode;

    public static AddressDTO toDto(AddressEntity address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddress(address.getAddress());
        addressDTO.setCity(address.getCity());
        addressDTO.setState(address.getState());
        addressDTO.setCountry(address.getCountry());
        addressDTO.setPostalCode(address.getPostalCode());

        return addressDTO;
    }

    public static AddressEntity toEntity(AddressDTO addressDTO) {
        AddressEntity address = new AddressEntity();
        address.setAddress(addressDTO.getAddress());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setCountry(addressDTO.getCountry());
        address.setPostalCode(addressDTO.getPostalCode());

        return  address;
    }
}
