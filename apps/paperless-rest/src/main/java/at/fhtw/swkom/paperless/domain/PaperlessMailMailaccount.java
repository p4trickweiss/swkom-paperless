package at.fhtw.swkom.paperless.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class PaperlessMailMailaccount {

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

    @Column(nullable = false, unique = true, length = 256)
    private String name;

    @Column(nullable = false, length = 256)
    private String imapServer;

    @Column
    private Integer imapPort;

    @Column(nullable = false)
    private Integer imapSecurity;

    @Column(nullable = false, length = 256)
    private String username;

    @Column(nullable = false, length = 2048)
    private String password;

    @Column(nullable = false, length = 256)
    private String characterSet;

    @Column
    private Integer ownerId;

    @Column(nullable = false)
    private Boolean isToken;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getImapServer() {
        return imapServer;
    }

    public void setImapServer(final String imapServer) {
        this.imapServer = imapServer;
    }

    public Integer getImapPort() {
        return imapPort;
    }

    public void setImapPort(final Integer imapPort) {
        this.imapPort = imapPort;
    }

    public Integer getImapSecurity() {
        return imapSecurity;
    }

    public void setImapSecurity(final Integer imapSecurity) {
        this.imapSecurity = imapSecurity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getCharacterSet() {
        return characterSet;
    }

    public void setCharacterSet(final String characterSet) {
        this.characterSet = characterSet;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(final Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Boolean getIsToken() {
        return isToken;
    }

    public void setIsToken(final Boolean isToken) {
        this.isToken = isToken;
    }

}
