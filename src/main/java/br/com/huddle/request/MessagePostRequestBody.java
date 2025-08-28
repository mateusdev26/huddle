package br.com.huddle.request;

import lombok.*;

import java.time.LocalDateTime;
@Data
public class MessagePostRequestBody {
    private String content ;
    private Long senderId;
    private Long recipientId;
}
