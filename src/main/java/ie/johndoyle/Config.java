package ie.johndoyle;

import ie.johndoyle.dao.CustomerDAO;
import ie.johndoyle.dao.ItemDAO;
import ie.johndoyle.dao.ItemDetailDAO;
import ie.johndoyle.entity.ItemDetail;
import ie.johndoyle.impl.CustomerImpl;
import ie.johndoyle.impl.ItemDetailImpl;
import ie.johndoyle.impl.ItemImpl;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Created by johnc on 10/6/2015.
 */
@Configuration
public class Config {

    @Bean
    public CustomerDAO customerDAO() {
        return new CustomerImpl();
    }

    @Bean
    public ItemDAO itemDAO() {return new ItemImpl();}

    @Bean
    public ItemDetailDAO itemDetailDAO() {return new ItemDetailImpl();}
}
