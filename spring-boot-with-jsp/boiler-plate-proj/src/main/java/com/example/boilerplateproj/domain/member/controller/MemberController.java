package com.example.boilerplateproj.domain.member.controller;

import com.example.boilerplateproj.domain.member.controller.form.MemberLoginForm;
import com.example.boilerplateproj.domain.member.controller.form.MemberRegisterForm;
import com.example.boilerplateproj.domain.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("58th/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService service;

    @PostMapping("/check-email/{email}")
    public Boolean emailValidation(@PathVariable("email") String email) {
        log.info("emailValidation(): " + email);

        return service.emailValidation(email);
    }

    @PostMapping("/sign-up")
    public Boolean signUp(@RequestBody MemberRegisterForm form) {
        log.info("signUp: " + form);

        return service.signUp(form.toMemberRegisterRequest());
    }

    @PostMapping("/sign-in")
    public String signIn(@RequestBody MemberLoginForm form) {
        log.info("signIn: " + form);

        return service.signIn(form.toLoginRequest());
    }
}
