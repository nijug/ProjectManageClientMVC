package com.example.projectmanageclientmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class IndexController {

    @GetMapping("/new")
    public String showAddProjectForm(Model model) {
        return "add-project";
    }

    @GetMapping("/manage")
    public String showManageProjects(Model model) {
        return "manage-projects";
    }


}