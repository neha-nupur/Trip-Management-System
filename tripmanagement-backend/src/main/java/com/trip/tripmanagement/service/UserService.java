package com.trip.tripmanagement.service;

import com.trip.tripmanagement.entity.User;
import com.trip.tripmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE
    public User create(User user) {
        return userRepository.save(user);
    }

    // GET ALL
    public List<User> getAll() {
        return userRepository.findAll();
    }

    // GET BY ID
    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    // UPDATE - PUT
    public User update(Integer id, User updatedUser) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {

            User user = optionalUser.get();

            user.setFullName(updatedUser.getFullName());
            user.setEmail(updatedUser.getEmail());
            user.setPhone(updatedUser.getPhone());
            user.setAge(updatedUser.getAge());
            user.setGender(updatedUser.getGender());

            return userRepository.save(user);
        }

        return null;
    }

    // PATCH
    public User patch(Integer id, User updatedUser) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {

            User user = optionalUser.get();

            if (updatedUser.getFullName() != null)
                user.setFullName(updatedUser.getFullName());

            if (updatedUser.getEmail() != null)
                user.setEmail(updatedUser.getEmail());

            if (updatedUser.getPhone() != null)
                user.setPhone(updatedUser.getPhone());

            if (updatedUser.getAge() != null)
                user.setAge(updatedUser.getAge());

            if (updatedUser.getGender() != null)
                user.setGender(updatedUser.getGender());

            return userRepository.save(user);
        }

        return null;
    }

    // DELETE
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}