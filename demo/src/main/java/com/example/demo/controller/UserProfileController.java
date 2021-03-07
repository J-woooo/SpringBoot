package com.example.demo.controller;

import com.example.demo.model.UserProfile;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserProfileController {

    private Map<String, UserProfile> userMap;

    @PostConstruct
    public void init() {
        userMap = new HashMap<String, UserProfile>();
        userMap.put("1", new UserProfile("1", "홍길동", "111-1111", "1동"));
        userMap.put("2", new UserProfile("2", "홍길자", "111-1112", "2동"));
        userMap.put("3", new UserProfile("3", "홍길순", "111-1113", "3동"));
    }

    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable("id") String id) {
        return userMap.get(id);
    }

    // 조회
    @GetMapping("user/all")
    public List<UserProfile> getUserProfileList() {
        return new ArrayList<UserProfile>(userMap.values());
    }

    // 생성
    @PostMapping("/user/{id}")
    public void putUserProfile(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        UserProfile userProfile = new UserProfile(id, name, phone, address);
        userMap.put(id, userProfile);
    }

    // 수정
    @PutMapping("/user/{id}")
    public void postUserProfile(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        UserProfile userProfile = userMap.get(id);
        userProfile.setName(name);
        userProfile.setAddress(address);
        userProfile.setPhone(phone);
    }

    // 삭제
    @DeleteMapping("/user/{id}")
    public void deleteProfile(@PathVariable("id") String id) {
        userMap.remove(id);
    }
}
