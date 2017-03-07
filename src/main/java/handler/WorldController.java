package handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by geyao on 2017/3/7.
 */
@Controller
public class WorldController {
    private static final Log logger = LogFactory.getLog(WorldController.class);
    @RequestMapping(value = "/world")
    public ModelAndView hello(){
        logger.info(this.getClass() + "的hello方法被调用");
        return new ModelAndView("/WEB-INF/content/welcome.jsp", "message", "GoodNight World");
    }
}
