package br.com.huddle.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages_tbl")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String content ;
    private Long senderId;
    private Long recipientId;
    private LocalDateTime sendingTime ;
    private boolean isRead;
}
