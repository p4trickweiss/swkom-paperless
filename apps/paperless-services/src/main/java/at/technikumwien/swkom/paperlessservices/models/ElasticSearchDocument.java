package at.technikumwien.swkom.paperlessservices.models;

public class ElasticSearchDocument {
    public int getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public String getContent() {
        return content;
    }

    private final int id;
    private final String filename;
    private final String content;

    public ElasticSearchDocument(int id, String filename, String content){
        this.id = id;
        this.filename = filename;
        this.content = content;
    }
}
