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
        return userRepository.findAll().stream().map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getBirthDate(), user.getPassword(), user.getRoles())).toList();
    }

    public UserDTO findById(Long id) {
        return converterUserParaUserDTO(userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado")));
    }

    private UserDTO converterUserParaUserDTO(User usuárioNãoEncontrado) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(usuárioNãoEncontrado.getId());
        userDTO.setName(usuárioNãoEncontrado.getName());
        userDTO.setEmail(usuárioNãoEncontrado.getEmail());
        userDTO.setPhone(usuárioNãoEncontrado.getPhone());
        userDTO.setBirthDate(String.valueOf(usuárioNãoEncontrado.getBirthDate()));
        userDTO.setPassword(usuárioNãoEncontrado.getPassword());
        userDTO.setRoles(usuárioNãoEncontrado.getRoles());
        return userDTO;
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = converterUserDTOParaUser(userDTO);
        UserDTO DTO = converterUserParaUserDTO(userRepository.save(user));
        return DTO;
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
        User user = converterUserDTOParaUser(userDTO);
        user.setId(id);
        user = userRepository.save(user);
        return converterUserParaUserDTO(user);
    }

    public UserDTO deleteUser(Long id) {
        userRepository.deleteById(id);
        return converterUserParaUserDTO(userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado")));
    }
}
