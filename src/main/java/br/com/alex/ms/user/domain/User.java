package br.com.alex.ms.user.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Long id;
    private String login;
    private String name;
    private String email;

}
