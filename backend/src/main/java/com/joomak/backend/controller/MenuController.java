package com.joomak.backend.controller;


import com.joomak.backend.MenuService;
import com.joomak.backend.domain.MenuBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
class MenuController {

    private final MenuService menuService;

    @GetMapping("/getAllMenu")
    public List<MenuBase> getAllMenu(){
        List<MenuBase> allMenu = menuService.findAllMenu();
        return allMenu;
    }
}