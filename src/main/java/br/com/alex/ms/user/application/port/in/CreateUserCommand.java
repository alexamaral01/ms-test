package br.com.alex.ms.user.application.port.in;

import br.com.alex.ms.shared.SelfValidating;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.ToString;

@ToString
public class  CreateUserCommand extends SelfValidating<CreateUserCommand> {

    @NotBlank
    private String login;

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    public @NotBlank String getLogin() {
        return login;
    }

    public @NotBlank String getName() {
        return name;
    }


    public @Email @NotBlank String getEmail() {
        return email;
    }

    public CreateUserCommand(String login, String name, String email) {
        super();

        this.login = login;
        this.name = name;
        this.email = email;

        this.selfValidate();
    }
}
