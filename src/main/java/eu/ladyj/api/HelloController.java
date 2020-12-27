package eu.ladyj.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @Value("${ladyj.application.name}")
    private String appName;

    @Value("${ladyj.application.version}")
    private String appVersion;


    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return appName + " v. " + appVersion;
    }
}
