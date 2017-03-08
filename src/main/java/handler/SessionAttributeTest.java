package handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by geyao on 2017/3/8.
 */
@Controller
@SessionAttributes("user")  //Model中属性名位user的属性放入HttpSession中
public class SessionAttributeTest {
    private static final Log logger = LogFactory.getLog(SessionAttributeTest.class);
    @RequestMapping("/session/{formName}")
    public  String logInForm(@PathVariable String formname){
        return formname;
    }
    @RequestMapping("/logIn")
    public String login(
            @RequestParam String logInName,
            @RequestParam String passWord,
            Model model){
        User user = new User();
        user.setLogInName(logInName);
        user.setPassWord(passWord);
        user.setUserName("admin");
        model.addAttribute("user", user);
        return "welcome";
    }
}
