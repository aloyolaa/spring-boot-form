package com.aloyolaa.springbootform.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component("elapsedTimeInterceptor")
public class ElapsedTimeInterceptor implements HandlerInterceptor {

    private final Logger logger = Logger.getLogger(ElapsedTimeInterceptor.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equalsIgnoreCase("post")) {
            return true;
        }
        if (handler instanceof HandlerMethod handlerMethod) {
            logger.log(Level.INFO, "Controller Method: {0}", handlerMethod.getMethod().getName());
        }
        logger.log(Level.INFO, "ElapsedTimeInterceptor: preHandle() entering...");
        logger.log(Level.INFO, "Intercepting {0}", handler);
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        Random random = SecureRandom.getInstanceStrong();
        int delay = random.nextInt(500);
        Thread.sleep(delay);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (request.getMethod().equalsIgnoreCase("get")) {
            long startTime = (long) request.getAttribute("startTime");
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            if (handler instanceof HandlerMethod) {
                modelAndView.addObject("elapsedTime", elapsedTime);
            }
            logger.log(Level.INFO, "Elapsed Time: {0} milliseconds", elapsedTime);
            logger.log(Level.INFO, "ElapsedTimeInterceptor: postHandle() entering...");
        }
    }

}
