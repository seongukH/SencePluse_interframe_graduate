package org.zerock.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
			ModelAndView modelAndView) throws Exception{
		System.out.println("postHandler...");
		
		HttpSession session = request.getSession();
		
		ModelMap modelMap = modelAndView.getModelMap();
		Object membervo = modelMap.get("MemberVO");
		System.out.println(""+membervo);
		
		if(membervo != null) {
			System.out.println("new login success");
			session.setAttribute("MemberVO", membervo);
			//response.sendRedirect("/interphone2/indivisual/viewAll");
		}
	}
	
	
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
    		 Object handler) throws Exception {
        // 세션 객체 생성
        HttpSession session = request.getSession();
        System.out.println("session get : "+session.getAttribute("MemberVO"));
        // 세션에 id가 null이면
               
        if(session.getAttribute("MemberVO") != null) {
           System.out.println("clear login data before");
           session.removeAttribute("MemberVO");
            // 컨트롤러를 실행(요청페이지로 이동한다.)
        }
        
         return true;
        
    }
    
 
}