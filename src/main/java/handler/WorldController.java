package handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.Writer;

/**
 * Created by geyao on 2017/3/7.
 */
@Controller
public class WorldController {
    private static final Log logger = LogFactory.getLog(WorldController.class);
//    @RequestMapping()
//    public ModelAndView hello(){
//        logger.info(this.getClass() + "的hello方法被调用");
//        return new ModelAndView("welcome", "message", "GoodNight World");
//    }

    @RequestMapping(value = "/helloworld")
    public String helloWorld(Model model,
                             @RequestParam(value = "param", required = true)String param,
                             HttpSession session, Writer out){
        model.addAttribute("message", param);
        return "welcome";
    }

    @RequestMapping(value = "/path/{userId}")
    public String pathVariableTest(@PathVariable(value = "userId") String message,
                                   Model model){
        model.addAttribute("message", message);
        return "welcome";
    }

    @RequestMapping(value = "/Header")
    public String headerTest(Model model,
                             @RequestHeader(value = "HOST", defaultValue = "default") String user,
                             @RequestHeader(value = "Accept") String[] accepts){
        model.addAttribute("message", user);
        System.out.println(accepts[0]);
        return "welcome";
    }
    @RequestMapping(value = "/cookie")
    public String cookieTest(@CookieValue(value = "JSESSIONID", defaultValue = "") String sessionId, Model model){
        model.addAttribute("message", sessionId);
        return "welcome";
    }
}
