package com.example.projectmanageclientmvc.controller;

import org.ProjectService.Project;
import org.ProjectService.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/projects")
public class ManageProjectsController {

    private ProjectService projectService;

    @GetMapping
    public String showManageProjects(Model model) {
        Project[] projects = projectService.readProjects();
        model.addAttribute("projects", projects);
        return "manage-projects";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Project project = projectService.getProjectById(id);
        model.addAttribute("project", project);
        return "edit-project";
    }

    @PostMapping("/edit")
    public String updateProject(@ModelAttribute Project project) {
        projectService.updateProjects(project);
        return "redirect:/projects";
    }

    @PostMapping("/delete/{id}")
    public String deleteProject(@PathVariable("id") Integer id) {
        projectService.deleteProjects(id);
        return "redirect:/projects";
    }
}