package at.fhtw.swkom.paperless.services;

import org.springframework.web.multipart.MultipartFile;

public interface IFileStorage {
    void upload(MultipartFile file);
    void download();
}
