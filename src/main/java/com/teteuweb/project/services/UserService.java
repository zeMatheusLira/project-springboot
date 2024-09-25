package com.teteuweb.project.services;

import com.teteuweb.project.dtos.UserRequestDTO;
import com.teteuweb.project.dtos.UserResponseDTO;
import com.teteuweb.project.entities.User;
import com.teteuweb.project.repositories.UserRepository;
import com.teteuweb.project.services.exceptions.DatabaseException;
import com.teteuweb.project.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //registra um serviço
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserRepository userRepository;

    public List<UserResponseDTO> findAll() {
        List<User> users =  userRepository.findAll();
        return users.stream().map(User::toResponseDTO).toList(); // converte cada entidade em DTO
    }

    public UserResponseDTO findById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return user.toResponseDTO();
    }

    public UserResponseDTO insert(UserRequestDTO obj) {
        User user = new User(obj); // converte o DTO para entidade
        user = repository.save(user); // Salva a entidade
        return user.toResponseDTO(); // Retorna o DTO de response
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }

    }

    public User update(Long id, User obj) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
