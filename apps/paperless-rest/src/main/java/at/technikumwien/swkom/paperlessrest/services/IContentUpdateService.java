package at.technikumwien.swkom.paperlessrest.services;

import at.technikumwien.swkom.paperlessrest.data.repos.DocumentsDocumentRepository;

public interface IContentUpdateService {
    void update(int id, String content);


}
