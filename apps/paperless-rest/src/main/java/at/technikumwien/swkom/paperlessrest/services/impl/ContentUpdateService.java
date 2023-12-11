package at.technikumwien.swkom.paperlessrest.services.impl;

import at.technikumwien.swkom.paperlessrest.data.domain.DocumentsDocument;
import at.technikumwien.swkom.paperlessrest.data.repos.DocumentsDocumentRepository;
import at.technikumwien.swkom.paperlessrest.services.IContentUpdateService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentUpdateService implements IContentUpdateService {

    private final DocumentsDocumentRepository documentRepository;

    @Autowired
    ContentUpdateService(DocumentsDocumentRepository documentRepository){
        this.documentRepository = documentRepository;
    }

    @Override
    public void update(int id, String content){
        DocumentsDocument entity = documentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));

        entity.setContent(content);
        documentRepository.save(entity);
    }

}
