package teamcapstonecafe.common;


import teamcapstonecafe.CustomermanagementApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CustomermanagementApplication.class })
public class CucumberSpingConfiguration {
    
}
