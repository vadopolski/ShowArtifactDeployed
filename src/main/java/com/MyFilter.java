package com;

import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class MyFilter implements Filter{  
  
public void init(FilterConfig arg0) throws ServletException {}  
      
public void doFilter(ServletRequest request, ServletResponse response,
    FilterChain chain) throws IOException, ServletException {    

    System.out.println("Filter is invoked before");

    PrintWriter out = response.getWriter();
    CharResponseWrapper responseWrapper = new CharResponseWrapper(
            (HttpServletResponse) response);

    chain.doFilter(request, responseWrapper);//sends request to next resource

    String servletResponse = new String(responseWrapper.toString());

    System.out.println("original servlet response: " + servletResponse);

    String newServletResponse = servletResponse
                .replace("alert('1');", "alert('replaced 1');")
                .replace("alert('2');", "alert('replaced 2');");

    System.out.println("replaced servlet response: " + newServletResponse);

    out.write(newServletResponse);
    
    System.out.println("Filter is invoked after");

    }  

    public void destroy() {}

}  