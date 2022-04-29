package com.practicewithdcb.user.service;

import com.practicewithdcb.user.VO.Department;
import com.practicewithdcb.user.VO.ResponseTemplateVO;
import com.practicewithdcb.user.entity.User;
import com.practicewithdcb.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        log.info("Inside the saveUser method of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user=userRepository.findByUserId(userId);

        Department department=restTemplate.getForObject("http://localhost:9001/departments/" +user.getDepartmentId(), Department.class);

     //   Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" +user.getDepartmentId(), Department.class);

        vo.setUser(user);
        vo.setDepartment(department);
return vo;
    }
}
