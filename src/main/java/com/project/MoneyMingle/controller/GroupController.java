package com.project.MoneyMingle.Controller;

import com.project.MoneyMingle.DTO.GroupDTO;
import com.project.MoneyMingle.DTO.TransactionDTO;
import com.project.MoneyMingle.Exception.GroupNotFoundException;
import com.project.MoneyMingle.Service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/settleUp/{groupId}")
    public ResponseEntity settleUpForGroup(@PathVariable("groupId") int groupId) throws GroupNotFoundException {
        List<TransactionDTO> transactions = groupService.settleUpByGroupId(groupId);//calling method from interface i.e service
        return ResponseEntity.ok(transactions);
    }

    //get the total amount spend by a user from a particular group

    @GetMapping("{groupId}/getExpense")//mapping a call
    public ResponseEntity getTotalAmount(@PathVariable("groupId")int groupId) throws GroupNotFoundException {
        double totalAmount=groupService.totalAmountSpentByUsers(groupId);
        return new ResponseEntity<>("Total Amount Spent by the group is "+totalAmount, HttpStatus.OK);
    }


    @PostMapping("/createGroup")
    public ResponseEntity<GroupDTO> CreateGroup(@RequestBody GroupDTO groupDTO){
        GroupDTO savedGroup = groupService.createGroup(groupDTO);
        return new ResponseEntity<>(savedGroup, HttpStatus.CREATED);
    }

}


