package inc.monster.app.user.client.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class User {
    private Long id;

    private String name;

    private String username;

    private String email;
}
