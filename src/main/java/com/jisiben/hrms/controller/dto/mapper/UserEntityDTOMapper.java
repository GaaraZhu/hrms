package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.UserDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.User;
import com.jisiben.hrms.util.EncryptUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class UserEntityDTOMapper implements Mapper<User, UserDTO> {
    SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public UserDTO toDTO(User entity) {
        return new UserDTO.Builder()
                .id(entity.getId())
                .setAccount(entity.getAccount())
                .setName(entity.getName())
                .setAuthority(entity.getAuthority())
                .build();
    }

    @Override
    public User toEntity(UserDTO dto, User entity) {
        String presentedPassword = StringUtils.isEmpty(dto.getPassword())? "123": dto.getPassword();
        return entity.name(dto.getName())
                .account(dto.getAccount())
                .password(EncryptUtil.encrypt(presentedPassword, dto.getAccount()))
                .authority(dto.getAuthority());
    }
}