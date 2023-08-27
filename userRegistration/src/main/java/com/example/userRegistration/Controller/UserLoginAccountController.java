package com.example.userRegistration.Controller;

import com.example.userRegistration.Constants.CommonConstants;
import com.example.userRegistration.Constants.SwaggerConstant;
import com.example.userRegistration.Dto.UserLoginAccountDTO;
import com.example.userRegistration.Service.UserLoginAccountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("v1/api/user")
@Api(tags = {SwaggerConstant.API_TAG})
public class UserLoginAccountController {

    @Autowired
    private UserLoginAccountService userLoginAccountService;

    @PostMapping("/saveUserAccount")
    public ResponseEntity<String> saveUserAccount(@RequestBody UserLoginAccountDTO dto) {
        return userLoginAccountService.saveUserLoginAccount(dto);
    }

    @PostMapping("/saveUpdateToken/{userName}")
    public ResponseEntity<String> saveUpdateToken(@RequestHeader(CommonConstants.AUTH_TOKEN) String token,
                                                  @PathVariable String userName) {
        token = getTrimedToken(token);
        return userLoginAccountService.saveUpdateToken(token, userName);
    }

    @GetMapping("/getHomePage")
    public String pageRedirection(@RequestHeader(CommonConstants.AUTH_TOKEN) String token) {
        token = getTrimedToken(token);
        return userLoginAccountService.getHomePage(token);
    }

    public String getTrimedToken(String token) {
        return token.substring(7);
    }

}
