package sshomeworkweektwo.demo.service;


import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    private static final String USER = "user";
    private static final String ADMIN = "admin";
    private int userCount;
    private int adminCount;

    public int getUserCount() {
        return userCount;
    }

    public int getAdminCount() {
        return adminCount;
    }

    @EventListener
    public void loginSuccessListener(AuthenticationSuccessEvent successEvent) {
        User user = (User) successEvent.getAuthentication().getPrincipal();

        if (isUser(user, USER)) {
            userCount++;
        } else if (isUser(user, ADMIN)) {
            adminCount++;
        }
    }

    private boolean isUser(User authenticationUser, String loginRole) {
        return authenticationUser.getUsername().equalsIgnoreCase(loginRole);
    }
}
