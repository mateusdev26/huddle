package br.com.huddle.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserPostRequestBody {
    private String username;
    private String password;
    private String email;
}
