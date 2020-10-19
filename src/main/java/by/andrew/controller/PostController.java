package by.andrew.controller;

import by.andrew.domain.*;
import by.andrew.service.CommentService;
import by.andrew.service.DislikeService;
import by.andrew.service.LikeService;
import by.andrew.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(path = "/post")
@Controller
public class PostController {
    @Autowired
    private DislikeService dislikeService;
    @Autowired
    private LikeService likeService;
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @GetMapping
    public ModelAndView getPage(ModelAndView modelAndView) {
        modelAndView.setViewName("createPost");
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView createPost(@Valid @ModelAttribute("post") Post post, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("createPost");
        } else {
            postService.save(post);
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @GetMapping(path = "/viewPost")
    public ModelAndView viewPost(@RequestParam long postId, ModelAndView modelAndView) {
        Post byId = postService.getById(postId);
        List<Comment> all = commentService.getByPostId(postId);
        List<Like> byPostId = likeService.getByPostId(postId);
        List<Dislike> byPostId1 = dislikeService.getByPostId(postId);
        int likes = byPostId.size();
        int dislikes = byPostId1.size();
        modelAndView.addObject("comments", all);
        modelAndView.addObject("post", byId);
//        modelAndView.addObject(likes);
        modelAndView.addObject("like", likes);
        modelAndView.addObject("dislike", dislikes);
        modelAndView.setViewName("viewPost");
        return modelAndView;
    }

    @PostMapping(path = "/like")
    public ModelAndView addLike(@RequestParam long postId, ModelAndView modelAndView, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        Like like = new Like(user,postId);
        List<Like> byPostId = likeService.getByPostId(postId);
//        likeService.save(like);
        if (byPostId.size() == 0){
            likeService.save(like);
        }
        else {
            for (Like like1 : byPostId) {
                if (like1.getUser().getLogin().equals (user.getLogin())) {
                    modelAndView.setViewName("redirect:/post/viewPost?postId=" + postId);
                } else {
                    likeService.save(like);
                }
            }
        }
        modelAndView.setViewName("redirect:/post/viewPost?postId=" + postId);
        return modelAndView;
    }

    @PostMapping (path = "/dislike")
    public ModelAndView addDislike (@RequestParam long postId, ModelAndView modelAndView, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        Dislike dislike = new Dislike(user,postId);
        List<Dislike> byPostId1 = dislikeService.getByPostId(postId);
        if (byPostId1.size() == 0) {
            dislikeService.save(dislike);
        } else {
            for (Dislike dislike1 : byPostId1) {
                if (dislike1.getUser().getLogin().equals(user.getLogin())) {
                    modelAndView.setViewName("redirect:/post/viewPost?postId=" + postId);
                } else {
                    dislikeService.save(dislike);
                }
            }
        }
        modelAndView.setViewName("redirect:/post/viewPost?postId=" + postId);
        return modelAndView;
    }
}
