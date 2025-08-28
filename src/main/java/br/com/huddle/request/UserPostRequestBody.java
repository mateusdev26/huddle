package br.com.huddle.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserPostRequestBody {
    private String username;
    private String password;
    private String email;
}
