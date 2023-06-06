package ru.inno.ec.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.inno.ec.models.Session;
import ru.inno.ec.security.details.CustomUserDetails;
import ru.inno.ec.services.SessionsService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/sessions")
public class SessionsController {

    private final SessionsService sessionsService;

    @PostMapping("/{session-id}/movies")
    public String addMovieToSession(@PathVariable("session-id") Long sessionId,
                                    @RequestParam("movie-id") Long movieId) {
        sessionsService.addMovieToSession(sessionId, movieId);
        return "redirect:/sessions/" + sessionId;
    }

    @PostMapping("/{session-id}/customers")
    public String addCustomerToSession(@PathVariable("session-id") Long sessionId,
                                       @RequestParam("customer-id") Long customerId) {
        sessionsService.addCustomerToSession(sessionId, customerId);
        return "redirect:/sessions/" + sessionId;
    }

    @GetMapping("/{session-id}")
    public String getSessionPage(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                 @PathVariable("session-id") Long sessionId, Model model) {
        model.addAttribute("role", customUserDetails.getCustomer().getRole());
        model.addAttribute("session", sessionsService.getSession(sessionId));
        model.addAttribute("notInSessionCustomers", sessionsService.getNotInSessionCustomers(sessionId));
        model.addAttribute("inSessionCustomers", sessionsService.getInSessionCustomers(sessionId));
        model.addAttribute("inSessionMovies", sessionsService.getInSessionMovies(sessionId));
        model.addAttribute("notInSessionMovies", sessionsService.getNotInSessionMovies(sessionId));
        return "sessions/session_page";
    }


    @GetMapping
    public String getSessionsPage(@AuthenticationPrincipal CustomUserDetails customUserDetails, Model model) {
        model.addAttribute("role", customUserDetails.getCustomer().getRole());
        model.addAttribute("sessions", sessionsService.getAllSessions());
        return "sessions/sessions_page";
    }

    @PostMapping
    public String addSession(Session session) {
        sessionsService.addSession(session);
        return "redirect:/sessions";
    }

    @GetMapping("/{session-id}/delete")
    public String deleteSession(@PathVariable("session-id") Long sessionId) {
        sessionsService.deleteSession(sessionId);
        return "redirect:/sessions/";
    }

    @PostMapping("/{session-id}/update")
    public String updateSession(@PathVariable("session-id") Long sessionId, Session session) {
        sessionsService.updateSession(sessionId, session);
        return "redirect:/sessions/" + sessionId;
    }
}
