package by.andrew.dto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

    @Data

    public class UserAuthDTO {
        @NotBlank
        @NotEmpty
        private String login;
        @NotBlank
        @NotEmpty
        private String password;

    }

