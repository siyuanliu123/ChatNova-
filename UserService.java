public interface UserService {
    void register(UserDto userDto);
    String login(LoginRequest loginRequest);
    void verifyEmail(String token);
}
