package at.technikumwien.swkom.paperlessrest.services;

import at.technikumwien.swkom.paperlessrest.data.elasticsearch.ElasticSearchDocument;
import co.elastic.clients.elasticsearch._types.Result;

import java.io.IOException;
import java.util.List;

public interface ISearchService {

    //Optional<Document> getDocumentById(int id);

    List<Integer> getDocumentByTitleContent(String text);
}
