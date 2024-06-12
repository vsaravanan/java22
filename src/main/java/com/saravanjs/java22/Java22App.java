package com.saravanjs.java22;

import com.saravanjs.java22.console.collection.LetterCombinations;
import com.saravanjs.java22.console.designpatterns.proxy.Internet;
import com.saravanjs.java22.console.designpatterns.proxy.ProxyInternet;
import com.saravanjs.java22.console.designpatterns.proxy.TestProxy;
import com.saravanjs.java22.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Sarav on 12 Jun 2024
 * @project govtech
 * @package console
 * @class Java22App
 */

@Configuration
@ComponentScan("com.saravanjs.java22")
@SpringBootApplication
@EnableAspectJAutoProxy
//@EnableTransactionManagement
public class Java22App implements CommandLineRunner  {

    @Autowired
    SampleService sampleService;

    public static void main(String[] args) {
        SpringApplication.run(Java22App.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        sampleService.performAction();

    }
}
