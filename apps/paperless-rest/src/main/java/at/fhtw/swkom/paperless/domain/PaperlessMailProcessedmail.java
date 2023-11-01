package at.fhtw.swkom.paperless.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.time.OffsetDateTime;


@Entity
public class PaperlessMailProcessedmail {

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

    @Column(nullable = false, length = 256)
    private String folder;

    @Column(nullable = false, length = 256)
    private String uid;

    @Column(nullable = false, length = 256)
    private String subject;

    @Column(nullable = false)
    private OffsetDateTime received;

    @Column(nullable = false)
    private OffsetDateTime processed;

    @Column(nullable = false, length = 256)
    private String status;

    @Column(columnDefinition = "text")
    private String error;

    @Column
    private Integer ownerId;

    @Column(nullable = false)
    private Integer ruleId;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(final String folder) {
        this.folder = folder;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(final String uid) {
        this.uid = uid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public OffsetDateTime getReceived() {
        return received;
    }

    public void setReceived(final OffsetDateTime received) {
        this.received = received;
    }

    public OffsetDateTime getProcessed() {
        return processed;
    }

    public void setProcessed(final OffsetDateTime processed) {
        this.processed = processed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(final String error) {
        this.error = error;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(final Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(final Integer ruleId) {
        this.ruleId = ruleId;
    }

}
