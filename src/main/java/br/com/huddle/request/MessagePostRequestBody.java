package br.com.huddle.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class MessagePostRequestBody {
    private String content ;
    private Long senderId;
    private Long recipientId;
    private LocalDateTime sendingTime ;
}
