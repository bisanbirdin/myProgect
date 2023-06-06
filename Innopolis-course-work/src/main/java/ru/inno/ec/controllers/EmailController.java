package ru.inno.ec.controllers;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.inno.ec.models.Customer;
import ru.inno.ec.security.details.CustomUserDetails;
import ru.inno.ec.services.CustomersService;
import ru.inno.ec.services.EmailService;
import ru.inno.ec.services.ProfileService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private static final Logger LOG = LoggerFactory.getLogger(EmailController.class);
    private final ProfileService profileService;
    private final CustomersService customersService;

    @Autowired
    EmailService emailService;

    @GetMapping
    public String getEmailPage(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        model.addAttribute("customer", profileService.getCurrent(userDetails));
        return "email_page";
    }

    @PostMapping("/{customer-email}")
    public @ResponseBody ResponseEntity sendSimpleEmail(@PathVariable("customer-email") String email) {
        try {
            emailService.sendSimpleService(email, "Welcome. Please, follow the link to confirm your email",
                    "http://localhost/signInNew/"+customersService.getCustomer(email).getId());
        } catch (MailException mailException) {
            LOG.error("Error while sending out email..{}", mailException.getStackTrace());
            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
    }
}
