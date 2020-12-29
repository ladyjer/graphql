package eu.ladyj.api;

import eu.ladyj.model.Useless;
import eu.ladyj.service.UselessService;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UselessController {
    @Value("${ladyj.application.name}")
    private String appName;

    @Value("${ladyj.application.version}")
    private String appVersion;

    public final UselessService service;

    public UselessController(UselessService service) {
        this.service = service;
    }

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return appName + " v. " + appVersion;
    }

    @RequestMapping("/useless")
    @ResponseBody
    public List<Useless> getUseless() {
        return IteratorUtils.toList(service.get().iterator());
    }
}
