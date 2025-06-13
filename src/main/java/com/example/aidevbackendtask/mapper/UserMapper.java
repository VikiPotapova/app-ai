package com.example.aidevbackendtask.mapper;

import com.example.aidevbackendtask.dto.AddressDTO;
import com.example.aidevbackendtask.dto.CompanyDTO;
import com.example.aidevbackendtask.dto.GeoDTO;
import com.example.aidevbackendtask.dto.UserDTO;
import com.example.aidevbackendtask.model.Address;
import com.example.aidevbackendtask.model.Company;
import com.example.aidevbackendtask.model.Geo;
import com.example.aidevbackendtask.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDto(User user);

    User toEntity(UserDTO dto);

    AddressDTO toDto(Address address);

    Address toEntity(AddressDTO dto);

    GeoDTO toDto(Geo geo);

    Geo toEntity(GeoDTO dto);

    CompanyDTO toDto(Company company);

    Company toEntity(CompanyDTO dto);
}