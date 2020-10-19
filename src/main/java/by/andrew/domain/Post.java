package by.andrew.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private static int incId = 0;
    private long postId = incId++;
    @NotBlank
    @NotEmpty
    private String title;
    @NotBlank
    @NotEmpty
    private String description;
    private User user;
    private List<Like> like;
    private List<Dislike> dislike;
}

