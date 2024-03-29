package com.banger.bangerapi.Controller;

import com.banger.bangerapi.Models.User;
import com.banger.bangerapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.DocFlavor;


@RestController
@CrossOrigin("*")
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUser/{username}")
    public ResponseEntity<?> getUser(@PathVariable("username") String username) throws Exception {
        return ResponseEntity.ok(userService.getUser(username));
    }
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") int id) throws Exception {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @PostMapping("/update/{username}")
    public ResponseEntity<?> updateUSer(@PathVariable("username") String username, @RequestBody User user) throws Exception {
        return userService.updateUser(user, username);
    }

    @PostMapping("/updatePassword/{username}")
    public ResponseEntity<?> updatePassword(@PathVariable("username") String username, @RequestBody User user) throws Exception {
        return userService.updatePassword(user, username);
    }

    @GetMapping("/getActiveUsers")
    private ResponseEntity<?> getActiveUsers() throws Exception {
        return ResponseEntity.ok(userService.getActiveUsers());
    }

    @GetMapping("/blacklistUser/{id}")
    public ResponseEntity<?> blacklistUser(@PathVariable int id) {
        return userService.blacklistUser(id);

    }

    @PostMapping(value = "/updateDocuments", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadFile(@RequestParam MultipartFile[] files, String username) {
        return userService.updateDocuments(files, username);
    }

    @GetMapping("/activateUser/{id}")
    public ResponseEntity<?> ActivateUser(@PathVariable int id) {
        return userService.activateUser(id);
    }

    @GetMapping("/getBlacklistedUsers")
    private ResponseEntity<?> getBlacklistedUsers() throws Exception {
        return ResponseEntity.ok(userService.getBlacklistedUsers());
    }

    @GetMapping("/dashboard")
    public  ResponseEntity<?> getDashboardDetails()throws Exception{
        return ResponseEntity.ok(userService.getDashBoardDetails());
    }
    @GetMapping("/deleteUser/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        return userService.deleteUser(username);
    }

}
