package com.heartiger.configurationtester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tester")
public class UserController {

    private final TesterConfig testerConfig;

    @Autowired
    public UserController(TesterConfig testerConfig) {
        this.testerConfig = testerConfig;
    }

    @GetMapping("/show")
    public String show() {
        return testerConfig.getName() + " " + String.valueOf(testerConfig.getAge());
    }
}
