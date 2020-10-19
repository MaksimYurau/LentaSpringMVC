package by.andrew.storage;

import by.andrew.domain.Like;
import by.andrew.domain.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LikeStorage {
    public List<Like> likes = new ArrayList<>();

    public boolean save(Like like) {
        return likes.add(like);
    }

    public List<Like> getByPost(long postId) {
        List<Like> likesPost = new ArrayList<>();
        for (Like like : likes) {
            if (like.getPostId() == postId) {
                likesPost.add(like);
            }
        }
        return likesPost;
    }

    public List<Like> getAll() {
        return likes;
    }
}
