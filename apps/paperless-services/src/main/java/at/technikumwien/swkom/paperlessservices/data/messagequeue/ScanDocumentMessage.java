package at.technikumwien.swkom.paperlessservices.data.messagequeue;

public class ScanDocumentMessage {
    private Integer id;
    private String path;

    public ScanDocumentMessage() {}

    public ScanDocumentMessage(Integer id, String path) {
        this.id = id;
        this.path = path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
