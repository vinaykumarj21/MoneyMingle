# MoneyMingle
A BILL SPLITTING APPLICATION
## Overview

  MoneyMingle is a SpringBoot Application designed to manage expenses and group finances. It allows users to create groups, add expenses and track how much each user owes or is owed within a group.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Schema](#schema)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Configuration](#configuration)
- [Contact](#contact)

## Introduction

MoneyMingle is a expense management application designed to simply group finances and ensure fair and transparent sharing of expenses. This project leverages Spring Boot to provide a robust backend infrastructure for handling users, groups, expenses and user interactions.

## Features

- User management 
- Group creation and management
- Expense tracking
- User expenses and settlements

## Schema

![image](https://github.com/SujiV-repo/Splitwise/assets/65115305/9eb36988-f143-4c2b-aa42-54ab2cbb25ec)


## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 17 or higher
- Maven
- MySQL or your preferred database

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/vinaykumarj21/MoneyMingle.git

2. Navigate to the project directory:

   ```bash
   cd MoneyMingle

3. Build the Project

   ```bash
   mvn clean install

## Usage

1. Running the application locally using the following command:

   ```bash
   mvn spring-boot:run

2. Visit 'http://localhost:8080' along with the API endpoint in you browser to access the Application.

## API Documentation

### Base URL

      http://localhost:8080/api-endpoint

### End Points

  ### Users

  **Creating Users**
  * **Endpoint:** 'POST/user/registerUser'
  * **Description:** Creating /Registering a new user 
  * **Request Body:**
    
    ```bash
          {
            "name" : "Mark",
            "email" : "mark45@gmail.com",
            "phoneNumber" : "8529647650"
          }
          
  * **Response:**
    
    ```bash
        {
            "name": "Mark",
            "email": "mark45@gmail.com",
            "phoneNumber": "8529647650"
        }
    
  
  **Adding Users to a group**
  * **Endpoint:** 'POST/user/{userID}/addUser/{groupId}'
  * **Description:** After registering the users, we can add users to any group 
  * **Request Parameters**
    
    ```bash
      http://localhost:8080/user/2/addUser/2          
  * **Response:**
    
    ```bash
      User added to the Group successfully
  
  **Getting group information for any user with UserID**
  * **Endpoint:** 'POST/user//{userId}/getGroups'
  * **Description:** Getting the group data for a particular user 
  * **Request Parameters:**
    
    ```bash
      http://localhost:8080/user/2/getGroups
            
  * **Response:**
    
    ```bash
        [
          {
            "headers": {},
            "body": {
              "groupName": "Tracking Expenses",
              "description": "To Track all the Expenses spent ",
              "defaultCurrency": "INR"
            },
            "statusCode": "OK",
            "statusCodeValue": 200
          },
          {
            "headers": {},
            "body": {
              "groupName": "Goa Trip Expense Tracking",
              "description": "To track expense for the goa trip",
              "defaultCurrency": "INR"
            },
            "statusCode": "OK",
            "statusCodeValue": 200
          }
      ]


### Groups

  **Creating a new Group**
  * **Endpoint:** 'POST/group/createGroup'
  * **Description:** Creating a new group
  * **Request Body:**
    
    ```bash
          {
            "groupName" : "Trip Expenses Group",
            "description" : "Created this group for the upcoming trip",
            "defaultCurrency" : "INR"
          }
          
  * **Response:**
    
    ```bash
        {
          "groupName": "Trip Expenses Group",
          "description": "Created this group for the upcoming trip",
          "defaultCurrency": "INR"
        }
    
  
  **Settling up the User Expenses**
  * **Endpoint:** 'GET/group/settleUp/{groupId}'
  * **Description:** Settling up all the user expenses in the group 
  * **Request Parameters**
    
    ```bash
      http://localhost:8080/group/settleUp/1         
  * **Response:**
    
    ```bash
      [
        {
          "fromUserName": "D",
          "toUserName": "A",
          "amount": 600.0
        },
        {
          "fromUserName": "C",
          "toUserName": "B",
          "amount": 400.0
        },
        {
          "fromUserName": "C",
          "toUserName": "A",
          "amount": 200.0
        }
      ]

  
  **Total Amount Spent by a Group**
  * **Endpoint:** 'GET/group/{groupId}/getExpense'
  * **Description:** Getting the total amount spent by a group 
  * **Request Parameters:**
    
    ```bash
      http://localhost:8080/group/1/getExpense            
  * **Response:**
    
    ```bash
     Total Amount spent by the Group is : 3000.0

### Expense

  **Creating Expense**
  * **Endpoint:** 'POST/expense/{groupId}/create-expense'
  * **Description:** Creating a new expense for existing group
  * **Request Body:**
    
    ```bash
          {
            "description" : "Food Expenses",
            "currency" : "INR"
          }          
  * **Response:**
    
    ```bash
        {
          "description": "Food Expenses",
          "currency": "INR"
        }

  **Total Amount for an expense**
  * **Endpoint:** 'GET/expense/{expenseId}/totalAmount'
  * **Description:** Getting the total amount spent for a particular expense 
  * **Request Parameters:**
    
    ```bash
      http://localhost:8080/expense/1/totalAmount           
  * **Response:**
    
    ```bash
     The total Amount spent is : 3000.0

### UserExpense

  **Creating a User Expense**
  * **Endpoint:** 'POST/userExpense/{userId}/createExpense'
  * **Description:** Creating a new user expense that an existing user made
  * **Request Body:**
    
    ```bash
          {
            "amount" : 600,
            "userExpenseType" : "HadToPay"
          }          
  * **Response:**
    
    ```bash
        User Expense Added Successfully

  **User Expense to Group Expense**
  * **Endpoint:** 'POST/userExpense//{expenseId}/addUserExpense/{userExpenseId}'
  * **Description:** Adding a single user expense to a group expense
  * **Request Parameters:**
    
    ```bash
      http://localhost:8080/userexpense/2/addUserExpense/2                 
  * **Response:**
    
    ```bash
     User Expense has been added Successfully in group
    
## Configuration
### Application Properties

The main configuration for the Splitwise project is stored in the `src/main/resources/application.properties` file. 
Below are key configurations that you may want to customize:

  **Database Configuration**
  
    spring.datasource.url=jdbc:mysql://localhost:3306/splitwise
    spring.datasource.username=root
    spring.datasource.password=root

  **Hibernate Configuration**
  
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
    spring.jpa.hibernate.ddl-auto=create
    spring.jpa.properties.hibernate.show_sql=true

  **Additional Hibernate Configuration**
      
      spring.jpa.show-sql=true


## Contact

If you have any questions, concerns, or suggestions, feel free to contact.

- **Email:** 
