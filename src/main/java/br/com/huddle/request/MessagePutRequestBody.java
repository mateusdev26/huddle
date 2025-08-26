package br.com.huddle.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class MessagePutRequestBody {
    private Long id ;
    private String content ;
    private Long senderId;
    private Long recipientId;
    private LocalDateTime sendingTime ;
    private boolean isRead ;
}
