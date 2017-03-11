package interceptor;

import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by geyao on 2017/3/11.
 */
public class InterceptorOne implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("ServletPath = " + request.getServletPath());
        System.out.println("ContextPath" + request.getContextPath());
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println();
        System.out.println("repuest = " + request);
        System.out.println("response = " + response);
        System.out.println("ModelAndView = " + modelAndView);
        System.out.println("handler = " + handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println();
        System.out.println("repuest = " + request);
        System.out.println("response = " + response);
        System.out.println("Exception = " + ex);
        System.out.println("handler = " + handler);
    }
}
