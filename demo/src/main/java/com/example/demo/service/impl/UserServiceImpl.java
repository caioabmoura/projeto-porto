package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.exception.UserException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void createUser(UserDTO userDTO) throws UserException {
        validateUserDTO(userDTO);
        User user = this.userMapper.toEntity(userDTO);
        user.setCreateTime(new Date());
        this.userRepository.save(user);

    }

    @Override
    public List<UserDTO> getAllUsers(){
        return this.userMapper.toDtoList(this.userRepository.findAll());
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new UserException("Usuário não encontrado.");
        }

        return this.userMapper.toDto(userOptional.get());
    }

    @Override
    public UserDTO updateById(Long id, UserDTO userDTO) {
        User user = this.userRepository.findById(id).orElseThrow(UserException::new);
        user.updateFromDTO(userDTO);

        this.userRepository.save(user);
        return this.userMapper.toDto(user);
    }

    @Override
    public void delete(Long id) {
        User user = this.userRepository.findById(id).orElseThrow(UserException::new);
        this.userRepository.delete(user);
    }

    private void validateUserDTO(UserDTO dto) throws UserException {
        if (dto == null) {
            throw new UserException("O usuário não pode ser nulo.");
        }

        if (isNullOrEmpty(dto.getName())) {
            throw new UserException("O nome é obrigatório.");
        }

        if (isNullOrEmpty(dto.getEmail())) {
            throw new UserException("O email é obrigatório.");
        }

        if (isNullOrEmpty(dto.getPhone())) {
            throw new UserException("O telefone é obrigatório.");
        }

        if (isNullOrEmpty(dto.getPassword())) {
            throw new UserException("A senha é obrigatória.");
        }

        if (isNullOrEmpty(dto.getConfirmPassword())) {
            throw new UserException("A confirmação de senha é obrigatória.");
        }

        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            throw new UserException("As senhas não coincidem.");
        }

        if (dto.getAge() == null || dto.getAge() <= 0) {
            throw new UserException("A idade deve ser maior que zero.");
        }
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }



}
