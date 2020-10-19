package by.andrew.service;

import by.andrew.domain.Like;
import by.andrew.storage.LikeStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    LikeStorage likeStorage;

    public boolean save(Like like) {
        return likeStorage.save(like);
    }

    public List<Like> getByPostId(long id) {
        return likeStorage.getByPost(id);
    }

    public List<Like> getAll() {
        return likeStorage.getAll();
    }
}
