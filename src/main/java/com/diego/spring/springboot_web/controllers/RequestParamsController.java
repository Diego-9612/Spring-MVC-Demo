package com.diego.spring.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diego.spring.springboot_web.controllers.models.dto.ParamDto;
import com.diego.spring.springboot_web.controllers.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "hola que tal") String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/bar")
    public ParamMixDto bar (@RequestParam String text, @RequestParam Integer code){
        ParamMixDto param2 = new ParamMixDto();
        param2.setMessage(text);
        param2.setCode(code);
        return param2;
    }

    @GetMapping("/request")
    public ParamMixDto request (HttpServletRequest request){
        Integer code = 10;
        try {
            code = Integer.parseInt(request.getParameter("code"));

        } catch (NumberFormatException e) {
        }
        ParamMixDto param = new ParamMixDto();
        param.setCode(code);
        param.setMessage(request.getParameter("message"));
        return param;
    }

}

