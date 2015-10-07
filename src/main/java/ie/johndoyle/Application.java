package ie.johndoyle;

import ie.johndoyle.dao.CustomerDAO;
import ie.johndoyle.entity.Customer;
import ie.johndoyle.impl.CustomerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
public class Application {

    private final AtomicLong counter = new AtomicLong();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
