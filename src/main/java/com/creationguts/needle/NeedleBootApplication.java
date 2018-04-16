package com.creationguts.needle;

import com.creationguts.needle.model.Customer;
import com.creationguts.needle.repo.CustomerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@EnableJpaRepositories("com.creationguts.needle.repo")
@EntityScan("com.creationguts.needle.model")
@SpringBootApplication
public class NeedleBootApplication {

    private static Logger logger = LogManager.getRootLogger();

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(NeedleBootApplication.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            logger.info(beanName);
        }
	}

	@Bean
    public String string1() {
        return "Foo";
    }

    @Bean
    public String string2() {
        return "Bar";
    }

	@Bean
    public CommandLineRunner demo(
            CustomerRepository repository,
            @Qualifier("string1") String string,
            @Qualifier("string2") String s) {
	    return args -> {
            System.out.println(repository + " " + string + " " + s);
            repository.save(new Customer("Banana Jack", "000000000-00", "bananaj@gmail.com"));
            repository.findAll().forEach(c -> System.out.println(c.getName()));
        };
    }
}
