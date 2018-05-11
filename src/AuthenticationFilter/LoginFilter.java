package AuthenticationFilter;


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

@WebFilter(urlPatterns={"/*"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig config)
        throws ServletException {
        // If you have any <init-param> in web.xml, then you could get them
        // here by config.getInitParameter("name") and assign it as field.
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        HttpSession session = request.getSession(false);
        
        String requestPath = request.getRequestURI();
      
        if (needsAuthentication(requestPath)&& session.getAttribute("user")==null) { 
            response.sendRedirect(request.getContextPath() + "/login"); 
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
    }

    
    private boolean needsAuthentication(String url) {
        String[] validNonAuthenticationUrls ={"/","/login","/home"};
        for(String validUrl : validNonAuthenticationUrls) {
            if (url.endsWith(validUrl)) {
                return false;
            }
        }
        return true;
    }
}