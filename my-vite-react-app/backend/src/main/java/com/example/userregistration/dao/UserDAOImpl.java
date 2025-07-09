package com.example.userregistration.dao;

import com.example.userregistration.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * In-memory implementation of UserDAO
 */
@Repository
public class UserDAOImpl implements UserDAO {
    
    private final Map<Long, UserDTO> usersById = new ConcurrentHashMap<>();
    private final Map<String, UserDTO> usersByUsername = new ConcurrentHashMap<>();
    private final Map<String, UserDTO> usersByEmail = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    
    @Override
    public UserDTO save(UserDTO userDTO) {
        // Check if username or email already exists
        if (usersByUsername.containsKey(userDTO.getUsername())) {
            throw new IllegalArgumentException("Username already exists: " + userDTO.getUsername());
        }
        
        if (usersByEmail.containsKey(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email already exists: " + userDTO.getEmail());
        }
        
        // Generate ID if not provided
        if (userDTO.getId() == null) {
            userDTO.setId(idCounter.getAndIncrement());
        }
        
        // Store user in maps
        usersById.put(userDTO.getId(), userDTO);
        usersByUsername.put(userDTO.getUsername(), userDTO);
        usersByEmail.put(userDTO.getEmail(), userDTO);
        
        return userDTO;
    }
    
    @Override
    public Optional<UserDTO> findById(Long id) {
        return Optional.ofNullable(usersById.get(id));
    }
    
    @Override
    public Optional<UserDTO> findByUsername(String username) {
        return Optional.ofNullable(usersByUsername.get(username));
    }
    
    @Override
    public Optional<UserDTO> findByEmail(String email) {
        return Optional.ofNullable(usersByEmail.get(email));
    }
    
    @Override
    public List<UserDTO> findAll() {
        return new ArrayList<>(usersById.values());
    }
    
    @Override
    public UserDTO update(UserDTO userDTO) {
        // Check if user exists
        if (!usersById.containsKey(userDTO.getId())) {
            throw new IllegalArgumentException("User not found with ID: " + userDTO.getId());
        }
        
        // Get existing user
        UserDTO existingUser = usersById.get(userDTO.getId());
        
        // Check if username is being changed and if new username already exists
        if (!existingUser.getUsername().equals(userDTO.getUsername()) && 
            usersByUsername.containsKey(userDTO.getUsername())) {
            throw new IllegalArgumentException("Username already exists: " + userDTO.getUsername());
        }
        
        // Check if email is being changed and if new email already exists
        if (!existingUser.getEmail().equals(userDTO.getEmail()) && 
            usersByEmail.containsKey(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email already exists: " + userDTO.getEmail());
        }
        
        // Remove old mappings
        usersByUsername.remove(existingUser.getUsername());
        usersByEmail.remove(existingUser.getEmail());
        
        // Update maps with new user data
        usersById.put(userDTO.getId(), userDTO);
        usersByUsername.put(userDTO.getUsername(), userDTO);
        usersByEmail.put(userDTO.getEmail(), userDTO);
        
        return userDTO;
    }
    
    @Override
    public boolean deleteById(Long id) {
        UserDTO user = usersById.remove(id);
        if (user != null) {
            usersByUsername.remove(user.getUsername());
            usersByEmail.remove(user.getEmail());
            return true;
        }
        return false;
    }
}