package br.com.alex.ms.user.adapter.out.persistence;

import br.com.alex.ms.user.application.port.out.CreateUserRepositoryPort;
import br.com.alex.ms.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements CreateUserRepositoryPort {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public User save(User user) {

        return Optional.of(user)
                .map(UserEntity::toEntity)
                .map(jpaUserRepository::save)
                .map(UserEntity::toDomain)
                .orElseThrow();
    }
}
