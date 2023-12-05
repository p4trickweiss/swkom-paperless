package at.technikumwien.swkom.paperlessservices.services;

import java.io.InputStream;

public interface IOCRWorker {
    String processFile(String fileName, InputStream fileInputStream);
}
