package com.thellamallama;

import com.thellamallama.entities.Tienda;
import com.thellamallama.repositories.TiendaReposiroty;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ThellamallamaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThellamallamaApiApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(TiendaReposiroty tiendaReposiroty){
        return args -> {
            Tienda norkys=new Tienda(
                    "norkys",
                    123,
                    "pass",
                    "juan",
                    "chosica",
                    "razon_no"
            );
            tiendaReposiroty.saveAll(List.of(norkys));
        };
    }
}
