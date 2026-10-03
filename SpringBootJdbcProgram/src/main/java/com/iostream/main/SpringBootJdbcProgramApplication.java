package com.iostream.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iostream.main.dao.UserDao;
import com.iostream.main.entity.User;

@SpringBootApplication
public class SpringBootJdbcProgramApplication implements CommandLineRunner {

    @Autowired
    private UserDao userDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcProgramApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Insert a new user
        User user = new User();
        
        user.setId(45); 
        user.setName("Alhan");
        user.setEmail("alhan@gmail.com");
        user.setCity("New Zealand");
        userDao.insertUser(user);

        // Update the same user
        user.setName("Alhan Updated");
        user.setEmail("alhan.updated@gmail.com");
        user.setCity("Australia");
        userDao.updateUser(user);

     // Delete the user using email
       userDao.deleteUser(45);
        
        // Select one user
          user =userDao.getUser("alhan@gmail.com");
        if (user != null)
        {
        	System.out.println("--------------------------");
            System.out.println("ID :" + user.getId());
            System.out.println("Name :" + user.getName());
            System.out.println("Email :" + user.getEmail());
            System.out.println("City :" + user.getCity());
        } else {
            System.out.println("User not found.");
        }

    }
}
