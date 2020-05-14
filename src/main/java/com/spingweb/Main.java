package com.spingweb;

import com.spingweb.Dao.FakeRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main
{
    public static void main(String[] args)
    {
        SpringApplication.run(Main.class,args);
    }
    @Bean
    public CommandLineRunner commrunner(ApplicationContext ctx)
    {
        return args ->
        {
            FakeRepo repo = new FakeRepo();
            System.out.println("Beans inspection");
            String[] name = ctx.getBeanDefinitionNames();

                repo.insertUser(1,"j","kl");

            /*for (String bname:name)
            {
                System.out.println(bname);
            }*/
        };
    }
}
