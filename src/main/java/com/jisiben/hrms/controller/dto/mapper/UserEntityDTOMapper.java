package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.UserDTO;
import com.jisiben.hrms.controller.dto.mapper.common.impl.AbstractMapper;
import com.jisiben.hrms.domain.entity.User;
import com.jisiben.hrms.service.UserService;
import com.jisiben.hrms.util.EncryptUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserEntityDTOMapper extends AbstractMapper<User, UserDTO> {

    @Autowired
    private UserService userService;

    @Override
    protected UserService getUserService() {
        return userService;
    }

    @Override
    public UserDTO toDTO(User entity) {
        UserDTO.Builder builder = (UserDTO.Builder)super.entityToDTO(entity, new UserDTO.Builder());
        return builder
                .setAccount(entity.getAccount())
                .setName(entity.getName())
                .setAuthority(1==entity.getAuthority()?"是":"否")
                .build();
    }

    @Override
    public User toEntity(UserDTO dto, User entity) {
        String presentedPassword = StringUtils.isEmpty(dto.getPassword())? "123": dto.getPassword();
        return entity.name(dto.getName())
                .account(dto.getAccount())
                .password(EncryptUtil.encrypt(presentedPassword, dto.getAccount()))
                .authority("是".equals(dto.getAuthority())?1:0);
    }
}