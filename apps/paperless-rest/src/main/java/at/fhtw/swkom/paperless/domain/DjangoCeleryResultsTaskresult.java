package at.fhtw.swkom.paperless.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.time.OffsetDateTime;


@Entity
public class DjangoCeleryResultsTaskresult {

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

    @Column(nullable = false, unique = true)
    private String taskId;

    @Column(nullable = false, length = 50)
    private String status;

    @Column(nullable = false, length = 128)
    private String contentType;

    @Column(nullable = false, length = 64)
    private String contentEncoding;

    @Column(columnDefinition = "text")
    private String result;

    @Column(nullable = false)
    private OffsetDateTime dateDone;

    @Column(columnDefinition = "text")
    private String traceback;

    @Column(columnDefinition = "text")
    private String meta;

    @Column(columnDefinition = "text")
    private String taskArgs;

    @Column(columnDefinition = "text")
    private String taskKwargs;

    @Column
    private String taskName;

    @Column(length = 100)
    private String worker;

    @Column(nullable = false)
    private OffsetDateTime dateCreated;

    @Column
    private String periodicTaskName;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(final String taskId) {
        this.taskId = taskId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(final String contentType) {
        this.contentType = contentType;
    }

    public String getContentEncoding() {
        return contentEncoding;
    }

    public void setContentEncoding(final String contentEncoding) {
        this.contentEncoding = contentEncoding;
    }

    public String getResult() {
        return result;
    }

    public void setResult(final String result) {
        this.result = result;
    }

    public OffsetDateTime getDateDone() {
        return dateDone;
    }

    public void setDateDone(final OffsetDateTime dateDone) {
        this.dateDone = dateDone;
    }

    public String getTraceback() {
        return traceback;
    }

    public void setTraceback(final String traceback) {
        this.traceback = traceback;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(final String meta) {
        this.meta = meta;
    }

    public String getTaskArgs() {
        return taskArgs;
    }

    public void setTaskArgs(final String taskArgs) {
        this.taskArgs = taskArgs;
    }

    public String getTaskKwargs() {
        return taskKwargs;
    }

    public void setTaskKwargs(final String taskKwargs) {
        this.taskKwargs = taskKwargs;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(final String taskName) {
        this.taskName = taskName;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(final String worker) {
        this.worker = worker;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getPeriodicTaskName() {
        return periodicTaskName;
    }

    public void setPeriodicTaskName(final String periodicTaskName) {
        this.periodicTaskName = periodicTaskName;
    }

}
