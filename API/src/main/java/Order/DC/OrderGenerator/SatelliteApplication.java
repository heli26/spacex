package Order.DC.OrderGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import Order.DC.OrderGenerator.Entities.Registration;

//8082:order generator
@SpringBootApplication
public class SatelliteApplication {

	static final String REGISTRY_URI = "http://localhost:9000/registry";
	static final String STEP_URI = "http://localhost:8082/step";
	static final String SERVICE_NAME = "SatelliteApplication";

	@RequestMapping(value = "/")
	public String root() {
		return "Satellite Application Service";
	}

	public static void main(String[] args) {
		SpringApplication.run(SatelliteApplication.class, args);
		//RestTemplate restTemplate = new RestTemplate();
       // Registration registration = new Registration();
        //registration.setName(SERVICE_NAME);
     //   registration.setUri(STEP_URI);
		//Result result = restTemplate.postForObject(REGISTRY_URI, registration, Result.class); 
	}


}
