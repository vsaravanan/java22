package console;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Sarav on 12 Jun 2024
 * @project govtech
 * @package console
 * @class Java22App
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class Java22App {
    public static void main(String[] args) {
        SpringApplication.run(Java22App.class, args);
    }
}
