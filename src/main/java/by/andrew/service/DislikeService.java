package by.andrew.service;

import by.andrew.domain.Dislike;
import by.andrew.storage.DislikeStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DislikeService {
    @Autowired
    DislikeStorage dislikeStorage;

    public boolean save (Dislike dislike) {
        return dislikeStorage.save(dislike);
    }

    public List<Dislike> getByPostId (long id) {
        return dislikeStorage.getByPost(id);
    }

    public List<Dislike> getAll () {
        return dislikeStorage.getAll();
    }
}
