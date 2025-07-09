package com.example.userregistration.service;

import com.example.userregistration.dto.UserDTO;
import java.util.List;

/**
 * Service interface for User operations
 */
public interface UserService {
    
    /**
     * Register a new user
     * 
     * @param userDTO the user to register
     * @return the registered user with generated ID
     * @throws IllegalArgumentException if username or email already exists
     */
    UserDTO registerUser(UserDTO userDTO);
    
    /**
     * Get a user by ID
     * 
     * @param id the user ID
     * @return the user
     * @throws IllegalArgumentException if user not found
     */
    UserDTO getUserById(Long id);
    
    /**
     * Get a user by username
     * 
     * @param username the username
     * @return the user
     * @throws IllegalArgumentException if user not found
     */
    UserDTO getUserByUsername(String username);
    
    /**
     * Get a user by email
     * 
     * @param email the email
     * @return the user
     * @throws IllegalArgumentException if user not found
     */
    UserDTO getUserByEmail(String email);
    
    /**
     * Get all users
     * 
     * @return list of all users
     */
    List<UserDTO> getAllUsers();
    
    /**
     * Update a user
     * 
     * @param userDTO the user to update
     * @return the updated user
     * @throws IllegalArgumentException if user not found or if username/email already exists
     */
    UserDTO updateUser(UserDTO userDTO);
    
    /**
     * Delete a user by ID
     * 
     * @param id the ID of the user to delete
     * @throws IllegalArgumentException if user not found
     */
    void deleteUser(Long id);
    
    /**
     * Check if a username is available
     * 
     * @param username the username to check
     * @return true if available, false if already taken
     */
    boolean isUsernameAvailable(String username);
    
    /**
     * Check if an email is available
     * 
     * @param email the email to check
     * @return true if available, false if already taken
     */
    boolean isEmailAvailable(String email);
}