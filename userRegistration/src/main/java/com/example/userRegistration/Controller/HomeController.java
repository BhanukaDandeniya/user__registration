package com.example.userRegistration.Controller;

import com.example.userRegistration.Constants.SwaggerConstant;
import com.example.userRegistration.Dto.Jwt.AuthRequest;
import com.example.userRegistration.Dto.Jwt.AuthResponse;
import com.example.userRegistration.Service.Jwt.UserDetailsServiceImpl;
import com.example.userRegistration.Util.JwtUtil;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Api(tags = {SwaggerConstant.API_TAG})
public class HomeController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/authenticate")
    public AuthResponse authenticate(@RequestBody AuthRequest authRequest) throws Exception {
        AuthResponse authResponse = new AuthResponse();
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            authResponse.setErrorMessage("INVALID_CREDENTIALS :" + e);
            return authResponse;
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String token = jwtUtil.generateToken(userDetails.getUsername());
        authResponse.setJwtToken(token);
        LOGGER.info("/****** HomeController -> authenticate() successful! " + token);
        return authResponse;
    }

}
