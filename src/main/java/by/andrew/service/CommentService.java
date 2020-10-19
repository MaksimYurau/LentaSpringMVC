package by.andrew.service;

import by.andrew.domain.Comment;
import by.andrew.domain.Post;
import by.andrew.storage.CommentStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
  @Autowired
    private CommentStorage commentStorage;
  public boolean save (Comment comment) {
     return commentStorage.save(comment);
  }

  public List<Comment> getAll(){
      return commentStorage.getAll();
  }
    public Comment getById(long id){
        return commentStorage.getById(id);
    }
    public List<Comment> getByPostId(long postId){
      return commentStorage.getByPostId(postId);
    }

}
