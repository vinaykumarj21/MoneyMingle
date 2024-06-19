package com.project.Splitwise.controller;

import com.project.Splitwise.DTO.GroupDTO;
import com.project.Splitwise.DTO.UserDTO;
import com.project.Splitwise.Exception.GroupNotFoundException;
import com.project.Splitwise.Exception.UserNotFoundException;
import com.project.Splitwise.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //creating a new user for the Application
    @PostMapping("/registerUser")
    public ResponseEntity RegisterUser(@RequestBody UserDTO userDTO){
        UserDTO savedUser = userService.registerUser(userDTO);
        return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
    }

    //fetching user info with the help of UserID
    @GetMapping("/{userId}/getUser")
    public ResponseEntity getUserById(@PathVariable int userId) throws UserNotFoundException {
        UserDTO userDTO = userService.getUserById(userId);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    //Fetching the Group info of a particular user with the help of userID
    @GetMapping("/{userId}/getGroups")
    public List<ResponseEntity> getGroupsInfo(@PathVariable int userId) throws UserNotFoundException{
        List<GroupDTO>groupDTOs=userService.getGroupsOfUser(userId);
        return groupDTOs.stream()
                .map(ResponseEntity::ok)
                .collect(Collectors.toList());
    }

    //Adding the user in Particular Group
    @PostMapping("/{userID}/addUser/{groupId}")
    public ResponseEntity UserAdditionInGroup(@PathVariable int userId,@PathVariable int groupId) throws UserNotFoundException, GroupNotFoundException {
        userService.addUserToGroup(userId,groupId);
        return ResponseEntity.ok("User Has Been Added Successfully in the Group");
    }
}
