package com.diego.spring.springboot_web.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import com.diego.spring.springboot_web.controllers.models.User;
import com.diego.spring.springboot_web.controllers.models.dto.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.userName}")
    private String userName;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("${config.code}")
    private Integer code;

    @Value("#{ '${config.listOfValues}'.split(',')}")
    private List<String> valueList;

    @Value("#{ '${config.listOfValues}'.toUpperCase()}")
    private String valueString;

    @Value("#{${config.valueMap}}")
    private Map<String, Object> valueMap;

    @Value("#{${config.valueMap}.product}")
    private String product;

    @Value("#{${config.valueMap}.price}")
    private double price;

    @Autowired
    private Environment environment;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable() String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/mix/{product}/{id}/")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        // Hacer algo aqui de logica
        user.setName(user.getName().toUpperCase());
        user.setLastName(user.getLastName().toUpperCase());
        user.setEmail(user.getEmail().toUpperCase());
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values() {
        Map<String, Object> json = new HashMap<>();
        json.put("User Name", userName);
        json.put("Message", message);
        json.put("Message 2", environment.getProperty("config.message"));
        json.put("Message", message);
        json.put("Code", code);
        json.put("Code 2", Integer.valueOf(environment.getProperty("config.code")));
        json.put("List Of Values", listOfValues);
        json.put("Value List", valueList);
        json.put("Value String", valueString);
        json.put(("Value Map"), valueMap);
        json.put(("Product"), product);
        json.put(("Price"), price);
        return json;

    }

}
