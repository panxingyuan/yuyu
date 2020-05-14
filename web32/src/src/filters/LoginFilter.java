package src.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName="LoginFilter", urlPatterns = {"*.do"})
public class LoginFilter implements Filter {
	
	@Override
	public void destroy() {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
        if(((HttpServletRequest) request).getSession().getAttribute("user") == null)
        	request.getRequestDispatcher("/login.jsp").forward(request,response);
        else
        	chain.doFilter(request, response);
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
	}

}
