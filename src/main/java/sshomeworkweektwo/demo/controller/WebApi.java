package sshomeworkweektwo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sshomeworkweektwo.demo.service.AuthenticationService;

import java.security.Principal;

@RestController
public class WebApi {

    private AuthenticationService authenticationService;

    @Autowired
    public WebApi(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/helloAdmin")
    public String helloAdmin(Principal principal) {
        return "Czesc Admin: " + principal.getName()
                + " zalogowales sie: "
                + authenticationService.getAdminCount()
                + " razy.";
    }

    @GetMapping("/helloUser")
    public String helloUser(Principal principal) {
        return "Czesc User: " + principal.getName()
                + " zalogowales sie: "
                + authenticationService.getUserCount()
                + " razy.";
    }

    @GetMapping("/helloAnonymous")
    public String helloAnonymous() {
        return "Czesc Nieznajomy";
    }

    @GetMapping("/bye")
    public String bye() {
        return "Pa pa";
    }
}
