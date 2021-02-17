package inc.monster.app.user.client.config;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "user.client")
@NoArgsConstructor
@Data
public class UserClientProperties {

    @NotNull
    private String scheme;
    @NotNull
    private String host;
    @NotNull
    private String port;
    @NotNull
    private String path;
}
