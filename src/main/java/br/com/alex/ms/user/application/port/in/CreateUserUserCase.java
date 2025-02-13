package br.com.alex.ms.user.application.port.in;

import br.com.alex.ms.user.domain.User;

public interface CreateUserUserCase {

    User createUser(CreateUserCommand createUserCommand);
}
