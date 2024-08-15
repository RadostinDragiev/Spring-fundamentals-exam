package com.philately.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@SessionScope
public class UserSession {

    private String id;
    private String username;

    public boolean isUserLogged() {
        return id != null;
    }

    public void login(String uuid, String username) {
        this.id = uuid;
        this.username = username;
    }

    public void logout() {
        id = null;
        username = "";
    }
}
