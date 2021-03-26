package com.ClientConnectivity.tradeSystem.config;


import com.ClientConnectivity.tradeSystem.utils.OrderValidationClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class OrderValidationConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.example.consumingwebservice.wsdl");
        return marshaller;
    }

    @Bean
    public OrderValidationClient orderValidationClient(Jaxb2Marshaller marshaller) {
        OrderValidationClient client = new OrderValidationClient();
        client.setDefaultUri("https://order-val.herokuapp.com/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
