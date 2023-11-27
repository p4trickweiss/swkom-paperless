package at.technikumwien.swkom.paperlessrest.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "DocumentsPaperlesstasks")
@Getter
@Setter
public class DocumentsPaperlesstask {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer id;

    @Column(nullable = false)
    private String taskId;

    @Column(nullable = false)
    private Boolean acknowledged;

    @Column
    private OffsetDateTime dateCreated;

    @Column
    private OffsetDateTime dateDone;

    @Column
    private OffsetDateTime dateStarted;

    @Column(columnDefinition = "text")
    private String result;

    @Column(nullable = false, length = 30)
    private String status;

    @Column
    private String taskFileName;

    @Column
    private String taskName;

}
