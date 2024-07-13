package com.example.demo.entity;

import com.example.demo.security.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private EContactStatus type;
    @Enumerated(EnumType.STRING)
    private StatusCreditCard status= StatusCreditCard.REQUEST;
    private String message;
}
