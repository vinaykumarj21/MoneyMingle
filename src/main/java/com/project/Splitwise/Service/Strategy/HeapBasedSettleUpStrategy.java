package com.project.Splitwise.Service.Strategy;

import com.project.Splitwise.DTO.TransactionDTO;
import com.project.Splitwise.Models.Expense;
import com.project.Splitwise.Models.User;
import com.project.Splitwise.Models.UserExpense;
import com.project.Splitwise.Models.UserExpenseType;

import java.util.*;

public class HeapBasedSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<TransactionDTO> settleUp(List<Expense> expenses) {
        HashMap<User,Double>outStandingAmountMap=new HashMap<>();//storing user and +ve/-ve respective amount
        List<TransactionDTO>transactions=new ArrayList<>();
        for(Expense expense:expenses) {//Loop through All the expenses
            for (UserExpense userExpense : expense.getUserExpenses()) {//expense has List<userExpense>
                User user = userExpense.getUser();//UserExpense has User
                double currentOutStandingAmount = outStandingAmountMap.getOrDefault(user, 0.00);
                //update User,amount in hashMap
                outStandingAmountMap.put(user, getOutStandingAmount(currentOutStandingAmount, userExpense));
            }
        }
            //MaxHeap Contains -> User:+ve Balance
            PriorityQueue<Map.Entry<User,Double>>maxHeap=new PriorityQueue<>(
                    (a,b)-> Double.compare(b.getValue(),a.getValue())//MaxHeap
            );

            //MinHeap -> User:-ve Balance
            PriorityQueue<Map.Entry<User,Double>>minHeap=new PriorityQueue<>(
                    (a,b)-> Double.compare(a.getValue(),b.getValue())
                    //Comparator.comparingDouble(Map.Entry::getValue)
            );

            //populate the heaps using the values from the Map
            for(Map.Entry<User,Double>entry :outStandingAmountMap.entrySet()){
                if(entry.getValue()<0)
                    minHeap.add(entry);
                else if(entry.getValue()>0)
                    maxHeap.add(entry);
                else
                    System.out.println(entry.getKey().getName() + "is already settledUp");
            }

            //calculate the Transactions until the heaps becomes empty(Settling up)
            while(!minHeap.isEmpty()){
                Map.Entry<User,Double>maxHasToPay=minHeap.poll();
                Map.Entry<User,Double>maxWillGetPaid=maxHeap.poll();
                TransactionDTO transactionDTO=new TransactionDTO(
                        maxHasToPay.getKey().getName(),
                        maxWillGetPaid.getKey().getName(),
                        Math.min(Math.abs(maxHasToPay.getValue()),maxWillGetPaid.getValue())
                );//values for constructor
                transactions.add(transactionDTO);//adding in the List
                double newBalance=maxHasToPay.getValue()+maxWillGetPaid.getValue();
                if(newBalance==0)
                    System.out.println("SettledUp for Users "+ maxHasToPay.getKey().getName() +" and "+maxWillGetPaid.getKey().getName());//No Need to add in the Heap
                else if(newBalance<0){//adding in the minheap
                    maxHasToPay.setValue(newBalance);
                    minHeap.add(maxHasToPay);
                }else {//adding in the maxheap -> balance > 0
                    maxWillGetPaid.setValue(newBalance);
                    maxHeap.add(maxWillGetPaid);
                }
            }
            return transactions;
    }
    private double getOutStandingAmount(double currentOutStandingAmount,UserExpense userExpense){
        if(userExpense.getUserExpenseType().equals(UserExpenseType.Paid)){
            currentOutStandingAmount=currentOutStandingAmount+ userExpense.getAmount();
        }else{
            //hadToPay
            currentOutStandingAmount=currentOutStandingAmount- userExpense.getAmount();
        }
        return currentOutStandingAmount;
    }
}
