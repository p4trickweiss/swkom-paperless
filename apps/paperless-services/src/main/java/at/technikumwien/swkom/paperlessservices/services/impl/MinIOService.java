package at.technikumwien.swkom.paperlessservices.services.impl;

import at.technikumwien.swkom.paperlessservices.config.MinIOConfig;
import at.technikumwien.swkom.paperlessservices.services.IFileStorage;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class MinIOService implements IFileStorage {
    private final MinIOConfig minIOConfig;

    @Autowired
    MinIOService(MinIOConfig minIOConfig) {
        this.minIOConfig = minIOConfig;
    }

    public InputStream download(String bucketPath) {
        try {
            MinioClient minioClient = minIOConfig.generateMinioClient();

            return minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(MinIOConfig.BUCKET_NAME)
                            .object(bucketPath)
                            .build());
        } catch (ServerException | InvalidResponseException e) {
            throw new RuntimeException(e);
        } catch (InsufficientDataException e) {
            throw new RuntimeException(e);
        } catch (ErrorResponseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (XmlParserException e) {
            throw new RuntimeException(e);
        } catch (InternalException e) {
            throw new RuntimeException(e);
        }
    }
}
