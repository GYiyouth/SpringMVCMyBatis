package handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by geyao on 2017/3/8.
 */
@Controller
public class FormHandler2 {
    @RequestMapping("/welcome")
    @ModelAttribute("message")
    public String logIn2(){
        return "FormHandler2admin";
    }
}
