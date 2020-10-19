package by.andrew.storage;

import by.andrew.domain.Comment;
import by.andrew.domain.Post;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommentStorage {
    public List<Comment> comments = new ArrayList<>();

    public boolean save(Comment comment) {
        return comments.add(comment);
    }

    public List<Comment> getAll() {
        return new ArrayList<>(comments);
    }

    public Comment getById(long id) {
        for (Comment comment : comments) {
            if (comment.getId() == id)
                return comment;
        }
        return null;
    }

    public List<Comment> getByPostId(long postId) {
        List<Comment> comments1 = new ArrayList<>();
        for (Comment comment : comments) {
            if (comment.getPostId() == postId) {
                comments1.add(comment);
            }
        }
        return comments1;
    }
}