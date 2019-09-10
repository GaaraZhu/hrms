package com.jisiben.hrms.controller;

import com.google.common.collect.ImmutableMap;
import com.jisiben.hrms.controller.common.AbstractController;
import com.jisiben.hrms.controller.dto.PageableSearchResultDTO;
import com.jisiben.hrms.controller.dto.ResetPasswordDTO;
import com.jisiben.hrms.controller.dto.UserDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.User;
import com.jisiben.hrms.service.UserService;
import com.jisiben.hrms.service.common.Service;
import com.jisiben.hrms.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.Optional;

@Controller
public class UserController extends AbstractController<User, UserDTO, User.Builder> {
    @Autowired
    private UserService service;

    @Autowired
    @Qualifier("userEntityDTOMapper")
    private Mapper<User, UserDTO> mapper;

    @ResponseBody
    @Produces("application/json")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public PageableSearchResultDTO<UserDTO> findAll(
            @RequestParam("name") String name,
            @RequestParam("account") String account,
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize) {
        return doFindAll(
                ImmutableMap.of(
                        "name", Optional.ofNullable(name),
                        "account", Optional.ofNullable(account)), currentPage, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserDTO find(Long id) { //TODO: optional serialization
        return doFind(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void add(@RequestBody UserDTO dto) {
        doAdd(dto);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(Long id, @RequestBody UserDTO dto) {
        doUpdate(id, dto);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam Long id, ModelMap model) {
        doDelete(id);
    }

    @RequestMapping(value="/updatePassword", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void updatePassword(@RequestBody ResetPasswordDTO dto, Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!EncryptUtil.match(userDetails.getPassword(), dto.getCurrentPassword(), userDetails.getUsername())) {
            throw new IllegalArgumentException("当前密码错误！！！");
        }
        service.updatePassword(userDetails.getUsername(), EncryptUtil.encrypt(dto.getNewPassword(), userDetails.getUsername()));
    }

    @Override
    protected Service<User> getService() {
        return service;
    }

    @Override
    protected Mapper<User, UserDTO> getMapper() {
        return mapper;
    }

    @Override
    protected User.Builder getEntityBuilder() {
        return new User.Builder();
    }
}
