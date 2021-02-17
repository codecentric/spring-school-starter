package inc.monster.app.domain;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ArticleScore extends AbstractTimestampEntity {

    private int score = 0;

    private int pageImpressionScore = 0;

    private int socialMediaScore = 0;

    private int videoViewsScore = 0;

    private int lengthOfStayScore = 0;

    private int exitScore = 0;

}
