package at.technikumwien.swkom.paperlessrest.services.impl;

import at.technikumwien.swkom.paperlessrest.config.MinIOConfig;
import at.technikumwien.swkom.paperlessrest.services.IFileStorage;
import io.minio.*;
import io.minio.errors.MinioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class MinIOFileStorage implements IFileStorage {
    private final MinIOConfig minIOConfig;

    @Autowired
    MinIOFileStorage(MinIOConfig minIOConfig) {
        this.minIOConfig = minIOConfig;
    }

    @Override
    public void upload(String bucketPath, MultipartFile file) {
        try {
            MinioClient minioClient = minIOConfig.generateMinioClient();

            boolean hasBucketWithName =
                    minioClient.bucketExists(
                            BucketExistsArgs
                                    .builder()
                                    .bucket(MinIOConfig.BUCKET_NAME)
                                    .build()
                    );
            if (!hasBucketWithName) {
                minioClient.makeBucket(
                        MakeBucketArgs
                                .builder()
                                .bucket(MinIOConfig.BUCKET_NAME)
                                .build()
                );
            }

            minioClient.putObject(
              PutObjectArgs.builder()
                      .bucket(MinIOConfig.BUCKET_NAME)
                      .object(bucketPath)
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
