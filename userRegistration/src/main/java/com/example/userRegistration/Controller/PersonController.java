package com.example.userRegistration.Controller;

import com.example.userRegistration.Constants.CommonConstants;
import com.example.userRegistration.Constants.SwaggerConstant;
import com.example.userRegistration.Dto.PersonDTO;
import com.example.userRegistration.Service.PersonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/person")
@Api(tags = {SwaggerConstant.API_TAG})
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/savePerson/{userAccountId}")
    public ResponseEntity<String> savePerson(@RequestHeader(CommonConstants.AUTH_TOKEN) String token,
                                             @RequestBody PersonDTO dto,
                                             @PathVariable String userAccountId) {
        token = getTrimedToken(token);
        return personService.savePerson(dto, userAccountId);
    }

    public String getTrimedToken(String token) {
        return token.substring(7);
    }

}
