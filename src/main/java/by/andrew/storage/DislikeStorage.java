package by.andrew.storage;

import by.andrew.domain.Dislike;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DislikeStorage {
    public List<Dislike> dislikes = new ArrayList<>();

    public boolean save (Dislike dislike) {
        return dislikes.add(dislike);
    }

    public List<Dislike> getByPost (long postId) {
        List<Dislike> dislikesPost = new ArrayList<>();
        for (Dislike dislike : dislikes) {
            if (dislike.getPostId() == postId) {
                dislikesPost.add(dislike);
            }
        }
        return dislikesPost;
    }

    public List<Dislike> getAll () {
        return dislikes;
    }
}
