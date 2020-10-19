package by.andrew.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private static long incId=0;
    private long id=incId++;
    private String description;
    private User user;
    private long postId;
@Autowired
    public Comment(String description, User user, long postId) {
        this.description = description;
        this.user = user;
        this.postId = postId;
    }
}
