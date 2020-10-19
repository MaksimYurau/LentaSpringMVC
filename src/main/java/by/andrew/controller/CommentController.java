package by.andrew.controller;

import by.andrew.domain.Comment;
import by.andrew.domain.User;
import by.andrew.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/comment")
public class CommentController {
    @Autowired
    public CommentService commentService;

    @PostMapping(path = "/save")
    public ModelAndView save(ModelAndView modelAndView, HttpSession httpSession, @RequestParam String description, @RequestParam long postId) {
        User user = (User) httpSession.getAttribute("user");
        Comment comment = new Comment(description, user, postId);
        commentService.save(comment);
        modelAndView.setViewName("redirect:/post/viewPost?postId=" + postId);
        return modelAndView;
    }

}
