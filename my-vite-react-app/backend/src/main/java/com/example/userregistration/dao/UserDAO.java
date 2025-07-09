package com.example.userregistration.dao;

import com.example.userregistration.dto.UserDTO;
import java.util.List;
import java.util.Optional;

/**
 * Data Access Object interface for User operations
 */
public interface UserDAO {
    
    /**
     * Save a new user
     * 
     * @param userDTO the user to save
     * @return the saved user with generated ID
     */
    UserDTO save(UserDTO userDTO);
    
    /**
     * Find a user by ID
     * 
     * @param id the user ID
     * @return an Optional containing the user if found, or empty if not found
     */
    Optional<UserDTO> findById(Long id);
    
    /**
     * Find a user by username
     * 
     * @param username the username to search for
     * @return an Optional containing the user if found, or empty if not found
     */
    Optional<UserDTO> findByUsername(String username);
    
    /**
     * Find a user by email
     * 
     * @param email the email to search for
     * @return an Optional containing the user if found, or empty if not found
     */
    Optional<UserDTO> findByEmail(String email);
    
    /**
     * Get all users
     * 
     * @return a list of all users
     */
    List<UserDTO> findAll();
    
    /**
     * Update an existing user
     * 
     * @param userDTO the user to update
     * @return the updated user
     */
    UserDTO update(UserDTO userDTO);
    
    /**
     * Delete a user by ID
     * 
     * @param id the ID of the user to delete
     * @return true if deleted, false if not found
     */
    boolean deleteById(Long id);
}