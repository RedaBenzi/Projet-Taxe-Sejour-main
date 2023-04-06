/*package com.example.demo.service.impl;

import com.example.demo.bean.User;
import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class UserService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserDao userDao;


    @Autowired
    private PasswordEncoder bcryptEncoder;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public User save(UserDTO user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        //newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(newUser);
    }
}
*/
//https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt
//source spring security

