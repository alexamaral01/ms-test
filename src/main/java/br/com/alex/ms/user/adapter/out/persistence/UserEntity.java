package br.com.alex.ms.user.adapter.out.persistence;

import br.com.alex.ms.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "USERS_SEQ", allocationSize = 1)
    private Long id;
    private String login;
    private String name;
    private String email;

    static UserEntity toEntity(User use) {
        return UserEntity.builder()
                .id(use.getId())
                .login(use.getLogin())
                .name(use.getName())
                .email(use.getEmail())
                .build();

    }

    static User toDomain(UserEntity use) {
        return User.builder()
                .id(use.getId())
                .login(use.getLogin())
                .name(use.getName())
                .email(use.getEmail())
                .build();
    }





}
