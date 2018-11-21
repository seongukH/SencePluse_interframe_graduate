package org.zerock.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
    		 Object handler) throws Exception {
        // 세션 객체 생성
        HttpSession session = request.getSession();
        System.out.println("session get : "+session.getAttribute("MemberVO"));
        // 세션에 id가 null이면
               
        if(session.getAttribute("MemberVO") == null) {
           System.out.println("not logined.");
          // session.removeAttribute("MemberVO");
           response.sendRedirect("/interphone2");
            // 컨트롤러를 실행(요청페이지로 이동한다.)
           return false;
        }
        
         return true;
        
    }
    
 
}