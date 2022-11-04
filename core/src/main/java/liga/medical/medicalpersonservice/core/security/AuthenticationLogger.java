package liga.medical.medicalpersonservice.core.security;

import liga.medical.medicalpersonservice.core.model.Log;
import liga.medical.medicalpersonservice.core.service.LogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@RequiredArgsConstructor
@Component
public class AuthenticationLogger implements ApplicationListener<AbstractAuthenticationEvent> {

    private final LogService logService;

    @Override
    public void onApplicationEvent(AbstractAuthenticationEvent authenticationEvent) {

        Authentication authentication = authenticationEvent.getAuthentication();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Log authLog = new Log();
        authLog.setUsername(authentication.getName());
        authLog.setInfo("Вход в аккаунт пользователя: " + authentication.getName() + " Доступ разрешен: " + authentication.isAuthenticated());
        authLog.setTime(timestamp);

        logService.addLog(authLog);

        log.info(timestamp + " Вход в аккаунт пользователя: " + authentication.getName() + " Доступ разрешен: " + authentication.isAuthenticated());
    }
}
