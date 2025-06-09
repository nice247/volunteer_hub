package com.vho.activ.controllers;

import com.vho.activ.models.Volunteer;
import com.vho.activ.service.CommitteeService;
import com.vho.activ.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class VolunteerController {

    private final VolunteerService volunteerService;

    private final CommitteeService committeeService;

    @Autowired
    public VolunteerController(VolunteerService volunteerService, CommitteeService committeeService) {
        this.volunteerService = volunteerService;
        this.committeeService = committeeService;
    }

    // صفحة التسجيل
    @GetMapping("/register")
    public String showVolunteerForm(Model model) {
        model.addAttribute("volunteer", new Volunteer());
        model.addAttribute("committees", committeeService.getAllCommittees());
        return "/register";
    }

    // معالجة التسجيل
    @PostMapping("/register")
    public String registerVolunteer(@ModelAttribute Volunteer volunteer) {
        volunteerService.saveVolunteer(volunteer); // حفظ بيانات المتطوع
        return "redirect:/home"; // تحويل المتطوع للصفحة الرئيسية
    }
}