package ru.inno.ec.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.inno.ec.security.details.CustomUserDetails;
import ru.inno.ec.services.ProfileService;

@RequiredArgsConstructor
@Controller
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/")
    public String getRoot() {
        return "redirect:profile";
    }

    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        model.addAttribute("role", userDetails.getCustomer().getRole());
        model.addAttribute("customer", profileService.getCurrent(userDetails));
        return "profile_page";
    }
}
