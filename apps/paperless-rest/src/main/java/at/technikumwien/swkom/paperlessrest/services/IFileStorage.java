package at.technikumwien.swkom.paperlessrest.services;

import org.springframework.web.multipart.MultipartFile;

public interface IFileStorage {
    void upload(String bucketPath, MultipartFile file);
    void download();
}
