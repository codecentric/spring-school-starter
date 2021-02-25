package inc.monster.app.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
class AuthListener implements ApplicationListener<AbstractAuthenticationEvent> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public void onApplicationEvent(final AbstractAuthenticationEvent event) {
        if (event instanceof AuthenticationSuccessEvent) {
            logger.info("Authentication successful: {}", event.getAuthentication().getName());
        }
        else if (event instanceof AuthenticationFailureBadCredentialsEvent) {
            logger.info("Authentication failure with bad credentials: {}" + event.getAuthentication().getName());
        }
    }

}
