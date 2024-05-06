package ru.testproj.book.backend.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.testproj.book.backend.api.dto.RegistrationUserDto;
import ru.testproj.book.backend.entity.Customer;
import ru.testproj.book.backend.entity.User;
import ru.testproj.book.backend.repository.CustomerRepository;
import ru.testproj.book.backend.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private RoleService roleService;
    private CustomerRepository customerRepository;

    private PasswordEncoder passwordEncoder;


    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

//поиск полььзователя
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("Пользователь '%s' не найден", username)
        ));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).toList());
    }
   //создание юзера
    @Transactional
    public User createNewUser(RegistrationUserDto registrationUserDto) {
        User user = new User();
        user.setUsername(registrationUserDto.getUsername());
        user.setEmail(registrationUserDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationUserDto.getPassword()));
        user.setRoles(List.of(roleService.getUserRole()));
        User registeredUser = userRepository.save(user);


        log.info("регистрация пользователя: {} успешна", registeredUser);
        return registeredUser;
    }
    //сохранить в БД db_book_customer как покупателя
    @Transactional
    public Customer createNewCustomer(RegistrationUserDto registrationUserDto) {
        Customer customer = new Customer();
        customer.setName(registrationUserDto.getUsername());
        customer.setEmail(registrationUserDto.getEmail());

        return customerRepository.save(customer);
    }

}
