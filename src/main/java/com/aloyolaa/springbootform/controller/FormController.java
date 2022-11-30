package com.aloyolaa.springbootform.controller;

import com.aloyolaa.springbootform.editor.CountryPropertyEditor;
import com.aloyolaa.springbootform.editor.NameCapitalLetterEditor;
import com.aloyolaa.springbootform.editor.RolePropertyEditor;
import com.aloyolaa.springbootform.model.Country;
import com.aloyolaa.springbootform.model.Role;
import com.aloyolaa.springbootform.model.User;
import com.aloyolaa.springbootform.service.CountryService;
import com.aloyolaa.springbootform.service.RoleService;
import com.aloyolaa.springbootform.validator.UserValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Controller
@SessionAttributes("user")
public class FormController {

    private UserValidator userValidator;

    private CountryService countryService;

    private RoleService roleService;

    private CountryPropertyEditor countryPropertyEditor;

    private RolePropertyEditor rolePropertyEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
        binder.registerCustomEditor(String.class, "firstName", new NameCapitalLetterEditor());
        binder.registerCustomEditor(String.class, "lastName", new NameCapitalLetterEditor());
        binder.registerCustomEditor(Country.class, "country", countryPropertyEditor);
        binder.registerCustomEditor(Role.class, "roles", rolePropertyEditor);
    }

    @ModelAttribute("countryList")
    public List<Country> countryList() {
        return countryService.findAll();
    }

    @ModelAttribute("roleList")
    public List<Role> roleList() {
        return roleService.findAll();
    }

    @ModelAttribute("genderList")
    public List<String> genderList() {
        return Arrays.asList("Male", "Female");
    }

    /*@ModelAttribute("roleList")
    public List<String> roleList() {
        return Arrays.asList("ROLE_ADMIN", "ROLE_USER", "ROLE_MODERATOR");
    }*/

    @ModelAttribute("rolesMap")
    public Map<String, String> rolesMap() {
        Map<String, String> roles = new HashMap<>();
        roles.put("ROLE_ADMIN", "Administrator");
        roles.put("ROLE_USER", "User");
        roles.put("ROLE_MODERATOR", "Moderator");
        return roles;
    }

    /*@ModelAttribute("countryList")
    public List<Country> countryList() {
        return Arrays.asList(
                new Country(1, "ES", "España"),
                new Country(2, "MX", "México"),
                new Country(3, "CL", "Chile"),
                new Country(4, "AR", "Argentina"),
                new Country(5, "PE", "Perú"),
                new Country(6, "CO", "Colombia"),
                new Country(7, "VE", "Venezuela")
        );
    }*/

    /*@ModelAttribute("countriesMap")
    public Map<String, String> countriesMap() {
        Map<String, String> countries = new HashMap<>();
        countries.put("ES", "España");
        countries.put("MX", "México");
        countries.put("CL", "Chile");
        countries.put("AR", "Argentina");
        countries.put("PE", "Perú");
        countries.put("CO", "Colombia");
        countries.put("VE", "Venezuela");
        return countries;
    }*/

    /*@ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("España", "México", "Chile", "Argentina", "Perú", "Colombia", "Venezuela");
    }*/

    @GetMapping("/form")
    public String form(Model model) {
        User user = new User();
        user.setDni("74635173");
        user.setFirstName("Alan");
        user.setLastName("Loyola");
        user.setEnable(true);
        user.setSecretValue("Secret Value");
        model.addAttribute("title", "User Form");
        model.addAttribute("user", user);
        return "form";
    }

    @PostMapping("/form")
    public String process(@Valid User user, BindingResult result, Model model) {
        //userValidator.validate(user, result);
        if (result.hasErrors()) {
            model.addAttribute("title", "Result");
            /*Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            model.addAttribute("errors", errors);*/

            return "form";
        }
        return "redirect:/view";
    }

    @GetMapping("/view")
    public String view(@SessionAttribute(name = "user", required = false) User user, Model model, SessionStatus status) {
        if (user == null) {
            return "redirect:/form";
        }
        model.addAttribute("title", "Result");
        status.setComplete();
        return "result";
    }

}
