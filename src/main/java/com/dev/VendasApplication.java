package com.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VendasApplication {

    /*A anotation @Value injeta o valor da propriedade que eu criei no arquivo application.properties
    * no atributo applicationName, sem necessidade de utilizar a @Bean e outras anotations que eu
    * estava utilizando. No site do SprigBoot application.properties existe a documentação com uma
    * infinidade de configurações que podem ser feitas*/
   @Value("${application.name}")
    public String applicationName;

   @Cachorro
   private Animal animal;

   @Bean
   public CommandLineRunner executar() {
       return args -> {
           this.animal.fazerBarulho();
       };
   }

    @GetMapping("/hello")
    public String helloWorld() {
        return applicationName;
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);



    }
}
