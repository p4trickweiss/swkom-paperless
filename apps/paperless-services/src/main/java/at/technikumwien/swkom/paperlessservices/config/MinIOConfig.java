package at.technikumwien.swkom.paperlessservices.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinIOConfig {
    public static String BUCKET_NAME = "documents";
    @Value("${minio.access.name}")
    private String accessKey;
    @Value("${minio.access.secret}")
    private String accessSecret;
    @Value("${minio.endpoint}")
    private String minioEndpoint;

    @Bean
    public MinioClient generateMinioClient() {
        try {
            return MinioClient.builder()
                            .endpoint(minioEndpoint, 9000, false)
                            .credentials(accessKey, accessSecret)
                            .build();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
