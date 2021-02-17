package inc.monster.app.hello.client.config;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "hello.client")
@NoArgsConstructor
@Data
public class HelloClientProperties {

    @NotNull
    private String scheme;
    @NotNull
    private String host;
    @NotNull
    private String port;
    @NotNull
    private String path;
}
