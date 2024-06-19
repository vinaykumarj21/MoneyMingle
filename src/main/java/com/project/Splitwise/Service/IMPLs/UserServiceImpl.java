package com.project.Splitwise.Service.IMPLs;

import com.project.Splitwise.DTO.GroupDTO;
import com.project.Splitwise.DTO.UserDTO;
import com.project.Splitwise.Exception.GroupNotFoundException;
import com.project.Splitwise.Exception.UserNotFoundException;
import com.project.Splitwise.Models.Group;
import com.project.Splitwise.Models.User;
import com.project.Splitwise.Repository.GroupRepository;
import com.project.Splitwise.Repository.UserRepository;
import com.project.Splitwise.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private GroupRepository groupRepository;

    private User fetchUserById(int userId) throws UserNotFoundException {
        return userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User is Not Registered with the ID :"+userId));
    }


    @Override
    public UserDTO getUserById(int userId) throws UserNotFoundException {
        User user = fetchUserById(userId);
        UserDTO userDTO=modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public List<GroupDTO> getGroupsOfUser(int userId) throws UserNotFoundException {
        User user=fetchUserById(userId);
        List<Group>groups=user.getGroups();
        return ConvertToGroupDTOs(groups);
    }

    private List<GroupDTO> ConvertToGroupDTOs(List<Group> groups) {
        return groups.stream()
                .map(this::ConvertToGroupDTO)
                .collect(Collectors.toList());
    }

    private GroupDTO ConvertToGroupDTO(Group group) {
        return modelMapper.map(group,GroupDTO.class);
    }

    @Override
    public void addUserToGroup(int userId, int groupId) throws UserNotFoundException, GroupNotFoundException {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new UserNotFoundException("User with the Id "+userId+ " is Not Present in the Group"));
        Group group=groupRepository.findById(groupId)
                .orElseThrow(()->new GroupNotFoundException("Group with the Id "+groupId+" is Not Present "));

        user.getGroups().add(group);
        group.getUsers().add(user);

        userRepository.save(user);
        groupRepository.save(group);
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user=modelMapper.map(userDTO,User.class);
        User savedUser=userRepository.save(user);
        return modelMapper.map(savedUser,UserDTO.class);
    }

}
