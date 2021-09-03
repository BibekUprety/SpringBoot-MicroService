package com.bibek.user.service;

import com.bibek.user.VO.Department;
import com.bibek.user.VO.ResponseTemplateVO;
import com.bibek.user.entity.User;
import com.bibek.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.NoSuchElementException;

@Service
public class UserService {

    private UserRepository userRepository;

    private RestTemplate restTemplate;

    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }



    public User saveUser(User user) {
        return userRepository.save(user);
    }



    public ResponseTemplateVO getUserWithDepartment(Long userId) {

        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" +user.getDepartmentId(),Department.class);

        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
