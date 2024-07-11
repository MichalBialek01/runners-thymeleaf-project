package pl.bialek.runnersthymeleafproject.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.bialek.runnersthymeleafproject.DTO.RegistrationDTO;
import pl.bialek.runnersthymeleafproject.entity.UserEntity;
import pl.bialek.runnersthymeleafproject.service.UserService;

@Controller
public class AuthController {
    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        //Need to be, whatever if it's empty
        RegistrationDTO user = new RegistrationDTO();
        model.addAttribute("user", user);
        return "/register";
    }

    @PostMapping("register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDTO user,
                           BindingResult bindingResult, Model model) {

        UserEntity existingUserEmail = userService.findUserByEmail(user.getEmail());
        if (existingUserEmail != null
                && existingUserEmail.getEmail() != null
                && !existingUserEmail.getEmail().isEmpty()) {
            return "redirect:/register?fail";
        }

        UserEntity existingUserUsername = userService.findByUsername(user.getUsername());
        if (existingUserUsername != null
                && existingUserUsername.getUsername() != null
                && !existingUserUsername.getUsername().isEmpty()) {
                    return "redirect:/register?fail";
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/clubs?success";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

}
