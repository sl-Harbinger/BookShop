package ru.testproj.book.backend.resource;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.testproj.book.backend.api.dto.AuthenticationRequestDto;
import ru.testproj.book.backend.entity.User;
import ru.testproj.book.backend.security.JwtTokenProvider;
import ru.testproj.book.backend.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("book-service/book/auth")
public class AuthenticationRestController {


    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    public AuthenticationRestController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = userService.findByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }
            String token = jwtTokenProvider.createToken(username, user.getRole().toString());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            return (ResponseEntity<?>) ResponseEntity.ok();
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }

    }

//    @PostMapping("/logout")
//    public void logout(HttpServletRequest request, HttpServletResponse response ){
//        SecurityContextServerLogoutHandler securityContextServerLogoutHandler=new SecurityContextServerLogoutHandler();
//        securityContextServerLogoutHandler.logout(request, response, null);
//    }
}
