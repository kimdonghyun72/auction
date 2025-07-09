package com.example.userregistration.service;

import com.example.userregistration.dao.UserDAO;
import com.example.userregistration.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of UserService
 */
@Service
public class UserServiceImpl implements UserService {
    
    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public UserServiceImpl(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }
    
    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        // Validate input
        if (userDTO.getUsername() == null || userDTO.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        
        if (userDTO.getPassword() == null || userDTO.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        
        if (userDTO.getEmail() == null || userDTO.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        
        // Check if username or email already exists
        if (!isUsernameAvailable(userDTO.getUsername())) {
            throw new IllegalArgumentException("Username already exists: " + userDTO.getUsername());
        }
        
        if (!isEmailAvailable(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email already exists: " + userDTO.getEmail());
        }
        
        // Encode password
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        
        // Save user
        return userDAO.save(userDTO);
    }
    
    @Override
    public UserDTO getUserById(Long id) {
        return userDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
    }
    
    @Override
    public UserDTO getUserByUsername(String username) {
        return userDAO.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found with username: " + username));
    }
    
    @Override
    public UserDTO getUserByEmail(String email) {
        return userDAO.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + email));
    }
    
    @Override
    public List<UserDTO> getAllUsers() {
        return userDAO.findAll();
    }
    
    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        // Validate input
        if (userDTO.getId() == null) {
            throw new IllegalArgumentException("User ID cannot be null for update");
        }
        
        // Check if user exists
        UserDTO existingUser = getUserById(userDTO.getId());
        
        // Check if username is being changed and if it's available
        if (!existingUser.getUsername().equals(userDTO.getUsername()) && 
            !isUsernameAvailable(userDTO.getUsername())) {
            throw new IllegalArgumentException("Username already exists: " + userDTO.getUsername());
        }
        
        // Check if email is being changed and if it's available
        if (!existingUser.getEmail().equals(userDTO.getEmail()) && 
            !isEmailAvailable(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email already exists: " + userDTO.getEmail());
        }
        
        // If password is provided and changed, encode it
        if (userDTO.getPassword() != null && !userDTO.getPassword().trim().isEmpty() && 
            !existingUser.getPassword().equals(userDTO.getPassword())) {
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        } else {
            // Keep existing password
            userDTO.setPassword(existingUser.getPassword());
        }
        
        // Update user
        return userDAO.update(userDTO);
    }
    
    @Override
    public void deleteUser(Long id) {
        if (!userDAO.deleteById(id)) {
            throw new IllegalArgumentException("User not found with ID: " + id);
        }
    }
    
    @Override
    public boolean isUsernameAvailable(String username) {
        return userDAO.findByUsername(username).isEmpty();
    }
    
    @Override
    public boolean isEmailAvailable(String email) {
        return userDAO.findByEmail(email).isEmpty();
    }
}