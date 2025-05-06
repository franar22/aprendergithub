package com.Repository.ahorasi;

public class classe {
    @SpringBootApplication
    @EnableFeignClients
    public class LoginApplication {
        public static void main(String[] args) {
            SpringApplication.run(LoginApplication.class, args);
        }
    }
    
    package com.example.login.client;
    +
    import com.example.Model.RegistroModel;
    import org.springframework.cloud.openfeign.FeignClient;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.http.ResponseEntity;
    
    @FeignClient(name = "Registro", url = "http://localhost:8085")
    public interface RegistroClient {

}


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;