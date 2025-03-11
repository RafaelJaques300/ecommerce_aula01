package com.senai.ecommerce_aula01.services;

import com.senai.ecommerce_aula01.dtos.UserDTO;
import com.senai.ecommerce_aula01.entities.User;
import com.senai.ecommerce_aula01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        List<User> List = userRepository.findAll();
        return userRepository.findAll().stream().map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getBirthDate(), user.getPassword(), user.getRoles())).toList();
    }

    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return converterUserParaUserDTO(user);
    }

    private UserDTO converterUserParaUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setBirthDate(String.valueOf(user.getBirthDate()));
        userDTO.setPassword(user.getPassword());
        userDTO.setRoles(user.getRoles());
        return userDTO;
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = converterUserDTOParaUser(userDTO);
        user = userRepository.save(user);
        return converterUserParaUserDTO(user);
    }

    private User converterUserDTOParaUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setBirthDate(LocalDate.parse(userDTO.getBirthDate()));
        user.setPassword(userDTO.getPassword());
        user.setRoles(userDTO.getRoles());
        return user;
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow();
        user.setId(id);
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setBirthDate(LocalDate.parse(userDTO.getBirthDate()));
        user.setPassword(userDTO.getPassword());
        user.setRoles(userDTO.getRoles());
        userRepository.save(user);
        return converterUserParaUserDTO(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

