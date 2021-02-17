package inc.monster.app.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Article extends AbstractTimestampEntity {

    @Column(unique = true, nullable = false)
    @NotNull
    private Long contentId;

    @Setter
    @Column(nullable = false)
    @NotBlank
    private String title;

    @Setter
    @Column(nullable = false)
    @NotBlank
    private String href;

    @Setter
    private String section;

    @Setter
    @Embedded
    private ArticleStatisticsData articleStatisticsData;

    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    private ArticleScore articleScore;
}
