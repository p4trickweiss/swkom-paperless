package at.technikumwien.swkom.paperlessrest.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan("at.technikumwien.swkom.paperlessrest.data.domain")
@EnableJpaRepositories("at.technikumwien.swkom.paperlessrest.data.repos")
@EnableTransactionManagement
public class DomainConfig {
}
