package teamcapstonecafe.common;


import teamcapstonecafe.CafemanagementApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CafemanagementApplication.class })
public class CucumberSpingConfiguration {
    
}
