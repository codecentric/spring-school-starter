package inc.monster.app.hello.client.config;

import inc.monster.app.hello.client.HelloClientPackage;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloClientProperties.class)
@ComponentScan(basePackageClasses = {HelloClientPackage.class})
public class HelloClientConfig {

}
