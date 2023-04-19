package ru.testproj.book.backend.security;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.testproj.book.backend.entity.User;
import ru.testproj.book.backend.security.jwt.JwtUser;
import ru.testproj.book.backend.security.jwt.JwtUserFactory;
import ru.testproj.book.backend.service.UserService;


@Service("userDetailServiceImpl")
//@RequiredArgsConstructor
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {


    private final UserService userService;

//    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

//    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN loadUserByUsername - user with username: {} successfully loaded", username);
        return jwtUser;
    }
}
