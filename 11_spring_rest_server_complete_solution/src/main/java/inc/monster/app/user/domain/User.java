package inc.monster.app.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Data
public class User {

    private Long id;

    private String name;

    private String username;

    private String email;

    public User(final Long id) {
        this.id = id;
    }
}
