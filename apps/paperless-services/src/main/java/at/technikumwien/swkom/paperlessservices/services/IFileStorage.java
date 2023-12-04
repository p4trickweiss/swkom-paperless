package at.technikumwien.swkom.paperlessservices.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface IFileStorage {
    InputStream download(String bucketPath);
}
