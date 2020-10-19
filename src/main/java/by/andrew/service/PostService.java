package by.andrew.service;

import by.andrew.domain.Post;
import by.andrew.storage.PostInMemmoryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostInMemmoryStorage postInMemmoryStorage;
    public void save(Post post) {
        postInMemmoryStorage.save(post);
    }
    public List<Post> getAll() {
        return postInMemmoryStorage.getAll();
    }
    public Post getById(long postId){
        return postInMemmoryStorage.getById(postId);
    }
}
