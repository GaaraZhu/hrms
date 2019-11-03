package com.jisiben.hrms.controller.dto;

import com.jisiben.hrms.controller.dto.common.DTORoot;

public class UserDTO extends DTORoot<UserDTO> {
    private String name;
    private String account;
    private String password;
    private String authority;

    public UserDTO() {
    }

    private UserDTO(UserDTO.Builder builder) {
        super(builder);
        this.name = builder.name;
        this.account = builder.account;
        this.password = builder.password;
        this.authority = builder.authority;
    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getAuthority() {
        return authority;
    }

    public static class Builder extends DTORoot.Builder<UserDTO.Builder, UserDTO> {
        private String name;
        private String account;
        private String password;
        private String authority;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAccount(String account) {
            this.account = account;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setAuthority(String authority) {
            this.authority = authority;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(this);
        }
    }
}
