package inc.monster.app.hello.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://monster.inc/hello")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Hello {

    private String message;
}
