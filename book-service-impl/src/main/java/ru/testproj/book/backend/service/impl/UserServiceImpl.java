package ru.testproj.book.backend.service.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.testproj.book.backend.entity.ERole;
import ru.testproj.book.backend.entity.Role;
import ru.testproj.book.backend.entity.User;
import ru.testproj.book.backend.repository.RoleRepository;
import ru.testproj.book.backend.repository.UserRepository;
import ru.testproj.book.backend.service.UserService;
import java.util.*;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

//    private final UserServiceImpl userServiceImpl;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;



//    @Autowired
//    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//    }



    @Override
    public User register(User user) {
        Role roleUser =roleRepository.findByName(ERole.ROLE_USER);
        List<Role> userRole =new ArrayList<>();
        userRole.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole( userRole);
        User registeredUser = userRepository.save(user);

        log.info("IN register user: {} successfully registered", registeredUser);
        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        log.info("IN getAll - {} users found", result.size());
        return result;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByLogin(username);
        log.info("IN findByUsername - user: {} found by username: {}", result, username);
        return result;
    }

    @Override
    public User findById(UUID id) {
        User result = userRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }

        log.info("IN findById - user: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted", id);

    }
}