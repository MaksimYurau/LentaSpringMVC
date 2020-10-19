package by.andrew.controller;

import by.andrew.domain.User;
import by.andrew.dto.UserAuthDTO;
import by.andrew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private  UserService userService;

    @GetMapping(path = "/authorization")
    public ModelAndView userAuthorization(ModelAndView modelAndView) {
        modelAndView.setViewName("authorization");
        modelAndView.addObject("user", new UserAuthDTO());
        return modelAndView;
    }

    @GetMapping(path = "/registration")
    public ModelAndView userRegistration(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @PostMapping(path = "/registration")
    public ModelAndView userRegistration (@Valid @ModelAttribute("user") User user, BindingResult bindingResult, ModelAndView modelAndView){
        System.out.println(bindingResult.getErrorCount());
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            modelAndView.setViewName("redirect:/");
            userService.save(user);
        }
        return modelAndView;
    }
    @PostMapping(path = "/authorization")
    public  ModelAndView userAuthorization (@Valid @ModelAttribute("user") UserAuthDTO userAuthDTO, BindingResult bindingResult, ModelAndView modelAndView, HttpSession httpSession){
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("authorization");
        } else {
            User userByLogin = userService.getByLogin(userAuthDTO.getLogin());
            if (userByLogin!=null) {
                if (userByLogin.getPassword().equals(userAuthDTO.getPassword())) {
                    httpSession.setAttribute("user",userByLogin);
                }
            }
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

//    @RequestMapping (path = "/logout")
//    public void logout (HttpServletRequest request, HttpServletResponse response) throws IOException {
//        request.getSession().invalidate();
//        response.sendRedirect("index");
//    }
}
