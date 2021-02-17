package inc.monster.app.user.client.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Long id;

    private String name;

    private String username;

    private String email;
}
