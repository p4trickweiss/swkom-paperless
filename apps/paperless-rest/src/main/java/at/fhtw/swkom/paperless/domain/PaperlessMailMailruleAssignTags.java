package at.fhtw.swkom.paperless.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class PaperlessMailMailruleAssignTags {

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
    private Integer mailruleId;

    @Column(nullable = false)
    private Integer tagId;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getMailruleId() {
        return mailruleId;
    }

    public void setMailruleId(final Integer mailruleId) {
        this.mailruleId = mailruleId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(final Integer tagId) {
        this.tagId = tagId;
    }

}
