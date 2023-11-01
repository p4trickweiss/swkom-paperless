package at.fhtw.swkom.paperless.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class GuardianGroupobjectpermission {

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
    private String objectPk;

    @Column(nullable = false)
    private Integer contentTypeId;

    @Column(nullable = false)
    private Integer groupId;

    @Column(nullable = false)
    private Integer permissionId;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getObjectPk() {
        return objectPk;
    }

    public void setObjectPk(final String objectPk) {
        this.objectPk = objectPk;
    }

    public Integer getContentTypeId() {
        return contentTypeId;
    }

    public void setContentTypeId(final Integer contentTypeId) {
        this.contentTypeId = contentTypeId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(final Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(final Integer permissionId) {
        this.permissionId = permissionId;
    }

}
