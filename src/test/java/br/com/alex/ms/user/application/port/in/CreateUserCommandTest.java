package br.com.alex.ms.user.application.port.in;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserCommandTest {

    @Test
    void invalidLogin(){
        assertThrows( ConstraintViolationException.class,
                ()-> new CreateUserCommand(null, null, null),
                "email: não deve estar em branco, name: não deve estar em branco, login: não deve estar em branco");
    }

    @Test
    void invalidLogin1(){
        assertThrows( ConstraintViolationException.class,
                ()-> new CreateUserCommand("aamaral", null, null),
                "email: não deve estar em branco, name: não deve estar em branco");
    }

    @Test
    void invalidLogin2(){
        assertThrows( ConstraintViolationException.class,
                ()-> new CreateUserCommand("aamaral", "Alex Amaral", null),
                "email: não deve estar em branco");
    }

    @Test
    void invalidLogin3(){
        assertThrows( ConstraintViolationException.class,
                ()-> new CreateUserCommand("aamaral", "Alex Amaral", "alex"),
                "email: não deve estar em branco");
    }

    @Test
    void invalidLogin4(){
        var createUserCommand = new CreateUserCommand("aamaral", "Alex Amaral", "alex@teste.com");

        assertEquals("aamaral", createUserCommand.getLogin());
        assertEquals("alex@teste.com", createUserCommand.getEmail());
        assertEquals("Alex Amaral", createUserCommand.getName());
    }

}