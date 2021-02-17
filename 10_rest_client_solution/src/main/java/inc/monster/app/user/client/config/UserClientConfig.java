package inc.monster.app.user.client.config;

import inc.monster.app.user.client.UserClientPackage;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserClientProperties.class)
@ComponentScan(basePackageClasses = {UserClientPackage.class})
public class UserClientConfig {
}
