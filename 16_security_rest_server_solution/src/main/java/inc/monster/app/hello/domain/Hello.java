package inc.monster.app.hello.domain;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(namespace = "http://monster.inc/hello")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Hello {

    private String message;
}
