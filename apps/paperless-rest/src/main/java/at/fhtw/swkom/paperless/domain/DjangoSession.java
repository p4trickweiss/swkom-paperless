package at.fhtw.swkom.paperless.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.OffsetDateTime;


@Entity
public class DjangoSession {

    @Id
    @Column(nullable = false, updatable = false, length = 40)
    private String sessionKey;

    @Column(nullable = false, columnDefinition = "text")
    private String sessionData;

    @Column(nullable = false)
    private OffsetDateTime expireDate;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(final String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getSessionData() {
        return sessionData;
    }

    public void setSessionData(final String sessionData) {
        this.sessionData = sessionData;
    }

    public OffsetDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(final OffsetDateTime expireDate) {
        this.expireDate = expireDate;
    }

}
