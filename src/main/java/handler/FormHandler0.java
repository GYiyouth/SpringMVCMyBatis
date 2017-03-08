package handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by geyao on 2017/3/8.
 */
@Controller
public class FormHandler0 {
//    @RequestMapping(value = "/{formName}")
    public String logInForm(@PathVariable String formName){
        return formName;
    }
}
