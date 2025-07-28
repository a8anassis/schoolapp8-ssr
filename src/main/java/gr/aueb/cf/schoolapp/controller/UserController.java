package gr.aueb.cf.schoolapp.controller;

import gr.aueb.cf.schoolapp.core.exceptions.EntityAlreadyExistsException;
import gr.aueb.cf.schoolapp.dto.UserInsertDTO;
import gr.aueb.cf.schoolapp.repository.RoleRepository;
import gr.aueb.cf.schoolapp.service.UserService;
import gr.aueb.cf.schoolapp.validator.UserInsertValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/school")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserInsertValidator userInsertValidator;
    private final RoleRepository roleRepository;

    @GetMapping("/users/register")
    public String getUserForm(Model model) {
        model.addAttribute("userInsertDTO", new UserInsertDTO());
        model.addAttribute("roles", roleRepository.findAll(Sort.by("name")));
        return "user-form";
    }

    @PostMapping("/users/register")
    public String insertUser(@Valid @ModelAttribute("userInsertDTO") UserInsertDTO userInsertDTO,
                             BindingResult bindingResult, Model model) {

        userInsertValidator.validate(userInsertDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("roles", roleRepository.findAll(Sort.by("name")));
            return "user-form";
        }

        try {
            userService.saveUser(userInsertDTO);
            return "redirect:/";
        } catch (EntityAlreadyExistsException e) {
            model.addAttribute("roles", roleRepository.findAll(Sort.by("name")));
            model.addAttribute("errorMessage", e.getMessage());
            return "user-form";
        }
    }
}
