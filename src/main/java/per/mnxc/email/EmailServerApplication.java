package per.mnxc.email;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Jiang
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
@EnableScheduling
@Slf4j
@MapperScan("per.mnxc.mapper")
public class EmailServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmailServerApplication.class, args);
        log.info("EmailServerApplication 启动");
    }
}