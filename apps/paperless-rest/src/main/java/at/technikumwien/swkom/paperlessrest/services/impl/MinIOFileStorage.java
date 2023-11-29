package at.technikumwien.swkom.paperlessrest.services.impl;

import at.technikumwien.swkom.paperlessrest.services.IFileStorage;
import io.minio.*;
import io.minio.errors.MinioException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
public class MinIOFileStorage implements IFileStorage {
    private final String BUCKET_NAME = "documents";

    @Override
    public void upload(MultipartFile file) {
        try {
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint("minio", 9000, false)
                            .credentials("admin", "admin-password")
                            .build();

            boolean hasBucketWithName =
                    minioClient.bucketExists(BucketExistsArgs.builder().bucket(BUCKET_NAME).build());
            if (!hasBucketWithName) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(BUCKET_NAME).build());
            }

            minioClient.putObject(
              PutObjectArgs.builder()
                      .bucket(BUCKET_NAME)
                      .object(file.getOriginalFilename())
                      .stream(file.getInputStream(), file.getSize(), -1)
                      .build()
            );

        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
            System.out.println("HTTP trace: " + e.httpTrace());
        } catch (IOException | NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void download() {

    }
}
