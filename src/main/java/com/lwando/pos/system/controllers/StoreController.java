package com.lwando.pos.system.controllers;


import com.lwando.pos.system.Service.StoreService;
import com.lwando.pos.system.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/store")
public class StoreController {

    private final StoreService storeService;
    private final UserService userService;

    //3:25:55
}
