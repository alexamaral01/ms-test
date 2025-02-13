package br.com.alex.ms.user.adapter.in.rest;

import br.com.alex.ms.user.application.port.in.CreateUserCommand;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
public class UserResource {

    private final AmqpTemplate amqpTemplate;

    @SneakyThrows
    @PostMapping("users")
    void addUserCreateQueue(@RequestBody CreateUserCommand createUserCommand) {

        var mapper = new ObjectMapper();
        var json = mapper.writeValueAsString(createUserCommand);

        amqpTemplate.send("create_user.queue", new Message(json.getBytes(StandardCharsets.UTF_8)));

    }


}
