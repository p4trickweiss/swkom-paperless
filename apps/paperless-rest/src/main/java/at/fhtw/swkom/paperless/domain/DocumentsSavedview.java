package at.fhtw.swkom.paperless.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class DocumentsSavedview {

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

    @Column(nullable = false, length = 128)
    private String name;

    @Column(nullable = false)
    private Boolean showOnDashboard;

    @Column(nullable = false)
    private Boolean showInSidebar;

    @Column(length = 128)
    private String sortField;

    @Column(nullable = false)
    private Boolean sortReverse;

    @Column
    private Integer ownerId;

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

    public Boolean getShowOnDashboard() {
        return showOnDashboard;
    }

    public void setShowOnDashboard(final Boolean showOnDashboard) {
        this.showOnDashboard = showOnDashboard;
    }

    public Boolean getShowInSidebar() {
        return showInSidebar;
    }

    public void setShowInSidebar(final Boolean showInSidebar) {
        this.showInSidebar = showInSidebar;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(final String sortField) {
        this.sortField = sortField;
    }

    public Boolean getSortReverse() {
        return sortReverse;
    }

    public void setSortReverse(final Boolean sortReverse) {
        this.sortReverse = sortReverse;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(final Integer ownerId) {
        this.ownerId = ownerId;
    }

}
