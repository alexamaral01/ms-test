package br.com.alex.ms.user.adapter.out.amqp;

import br.com.alex.ms.user.application.port.in.CreateUserCommand;
import br.com.alex.ms.user.application.port.in.CreateUserUserCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateUserQueueListener {

    private final CreateUserUserCase createUserUserCase;

    @RabbitListener(queues = "create_user.queue")
    void handler(CreateUserCommand createUserCommand){

        try {
            var user = createUserUserCase.createUser(createUserCommand);
            log.info("Usuário criado com sucesso -> id: {}", user.getId());
        } catch (DataIntegrityViolationException ex){
            log.error("Erro ao criar Usuário ", ex);
        }
    }

}
