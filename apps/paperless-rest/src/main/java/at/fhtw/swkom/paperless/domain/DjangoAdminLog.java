package at.fhtw.swkom.paperless.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.time.OffsetDateTime;


@Entity
public class DjangoAdminLog {

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
    private OffsetDateTime actionTime;

    @Column(columnDefinition = "text")
    private String objectId;

    @Column(nullable = false, length = 200)
    private String objectRepr;

    @Column(nullable = false)
    private Integer actionFlag;

    @Column(nullable = false, columnDefinition = "text")
    private String changeMessage;

    @Column
    private Integer contentTypeId;

    @Column(nullable = false)
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public OffsetDateTime getActionTime() {
        return actionTime;
    }

    public void setActionTime(final OffsetDateTime actionTime) {
        this.actionTime = actionTime;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(final String objectId) {
        this.objectId = objectId;
    }

    public String getObjectRepr() {
        return objectRepr;
    }

    public void setObjectRepr(final String objectRepr) {
        this.objectRepr = objectRepr;
    }

    public Integer getActionFlag() {
        return actionFlag;
    }

    public void setActionFlag(final Integer actionFlag) {
        this.actionFlag = actionFlag;
    }

    public String getChangeMessage() {
        return changeMessage;
    }

    public void setChangeMessage(final String changeMessage) {
        this.changeMessage = changeMessage;
    }

    public Integer getContentTypeId() {
        return contentTypeId;
    }

    public void setContentTypeId(final Integer contentTypeId) {
        this.contentTypeId = contentTypeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

}
