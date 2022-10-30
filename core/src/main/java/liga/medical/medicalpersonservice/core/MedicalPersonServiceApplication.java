package liga.medical.medicalpersonservice.core;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Liga medical project", version = "1.0", description = "Medical service"))
public class MedicalPersonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalPersonServiceApplication.class, args);
    }
}
