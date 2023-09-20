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


@WebFilter(filterName="adminFilter",
urlPatterns={"/admin/*"})
public class AdminFilter implements Filter {




	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse) response;

		HttpSession session = req.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(loginMember.getAuthority() != 1) { // 관리자가 아니라면 메인 페이지로
			session.setAttribute("message", "잘못된 접근입니다.");
			resp.sendRedirect("/"); 
		}else {
			chain.doFilter(request, response);
			
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
