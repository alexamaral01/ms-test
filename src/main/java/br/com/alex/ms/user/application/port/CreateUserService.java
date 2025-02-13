package br.com.alex.ms.user.application.port;

import br.com.alex.ms.user.application.port.in.CreateUserCommand;
import br.com.alex.ms.user.application.port.in.CreateUserUserCase;
import br.com.alex.ms.user.application.port.out.CreateUserRepositoryPort;
import br.com.alex.ms.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUserCase {

    private final CreateUserRepositoryPort createUserRepository;

    @Override
    public User createUser(CreateUserCommand createUserCommand) {

        var user = User.builder()
                .login(createUserCommand.getLogin())
                .name(createUserCommand.getName())
                .email(createUserCommand.getEmail())
                .build();

        return createUserRepository.save(user);
    }
}
