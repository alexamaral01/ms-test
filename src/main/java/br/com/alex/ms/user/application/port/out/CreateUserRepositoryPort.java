package br.com.alex.ms.user.application.port.out;

import br.com.alex.ms.user.domain.User;

public interface CreateUserRepositoryPort {

    User save(User user);

}
