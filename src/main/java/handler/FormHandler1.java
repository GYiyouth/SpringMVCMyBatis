package handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by geyao on 2017/3/8.
 */
@Controller
public class FormHandler1 {
    @ModelAttribute("message")
    public User userModel1(
            @RequestParam("logInName")String logInName){
        User user = new User();
        user.setLogInName(logInName);
        return user;
    }
    @RequestMapping("/logIn1")
    public String logIn1(){
                return "welcome";
    }
}
