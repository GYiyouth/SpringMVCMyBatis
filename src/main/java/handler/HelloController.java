package handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by geyao on 2017/3/7.
 */
public class HelloController implements Controller{
    private static final Log logger = LogFactory.getLog(HelloController.class);

    /**
     * 返回一个包含视图名，或者 视图名和视图模型的ModelAndView对象
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     * @throws Exception
     */
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        logger.info("handleRequest 被调用");
        ModelAndView mv = new ModelAndView();
        //添加模型对象，可以是任意的POJO对象
        String message = "Hello World";
        mv.addObject("message", message);
        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mv.setViewName("/WEB-INF/content/welcome.jsp");
        return mv;
    }
}
