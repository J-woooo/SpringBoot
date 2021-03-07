package com.example.demo.controller;

import com.example.demo.mapper.UserProfileMapper;
import com.example.demo.model.UserProfile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserProfileController {

    private UserProfileMapper mapper;


    public UserProfileController(UserProfileMapper mapper) {
        this.mapper = mapper;
    }

    // 특정 id 조회
    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable("id") String id) {
        return mapper.getUserProfile(id);
    }

    // 조회
    @GetMapping("user/all")
    public List<UserProfile> getUserProfileList() {
        return mapper.getUserProfileList();
    }

    // 생성
    @PostMapping("/user/{id}")
    public void putUserProfile(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        mapper.insertUserProfile(id, name, phone, address);
    }

    // 수정
    @PutMapping("/user/{id}")
    public void postUserProfile(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
       mapper.updateUserProfile(id, name, phone, address);
    }

    // 삭제
    @DeleteMapping("/user/{id}")
    public void deleteProfile(@PathVariable("id") String id) {
       mapper.deleteUserProfile(id);
    }
}
