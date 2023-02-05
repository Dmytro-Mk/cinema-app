package cinema.dto.request;

import cinema.lib.Email;
import cinema.lib.FieldsValueMatch;
import cinema.lib.Password;

@FieldsValueMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords do not match!"
)
public class UserRequestDto {
    @Email
    private String email;
    @Password
    private String password;
    private String repeatPassword;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}
