package by.andrew.storage;

import by.andrew.domain.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostInMemmoryStorage {
    private List<Post> posts = new ArrayList<>();

    public void save(Post post) {
        posts.add(post);

    }

    public List<Post> getAll() {
        return new ArrayList<>(posts);
    }

    public Post getById(long postId) {
        for (Post post : posts) {
            if (post.getPostId() == postId) {
                return post;
            }
        }
        return null;
    }
}
