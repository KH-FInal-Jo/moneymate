package edu.kh.project.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.project.member.model.dto.Member;

@WebFilter(filterName="loginFilter",
urlPatterns={"/subscribe/*"})
public class LoginFilter implements Filter {


	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("--- 로그인 필터 생성 ---");
	}



	public void destroy() {
		System.out.println("--- 이전 로그인 필터 파괴 ---");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse) response;

		HttpSession session = req.getSession();

		if(session.getAttribute("loginMember") == null) {
			session.setAttribute("message", "로그인 후 이용해주세요.");
			resp.sendRedirect("/");

			// 4) 로그인 상태인 경우 다음 필터 또는 
			//    DispatcherServlet으로 전달
		} else {
			chain.doFilter(request, response);
		}
	}



}
