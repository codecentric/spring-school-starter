package inc.monster.app.domain;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ArticleStatisticsData implements Serializable {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate statisticsCreationDate;

    private int pageImpressionsCount = 0;

    private int socialMediaCount = 0;

    private BigDecimal socialMediaRate;

    private int videoViewCount = 0;

    private BigDecimal videoViewRate;

    private int exitCount = 0;

    private BigDecimal exitRate;

    private BigDecimal pageDurationAvg;


}
