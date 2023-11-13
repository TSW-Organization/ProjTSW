package it.unisa.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//@WebFilter("/*")
public class MyFilter implements Filter {
	
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        //Imposta gli attributi comuni per tutte le pagine
        httpRequest.setAttribute("showHeader", true);
        httpRequest.setAttribute("showFooter", true);
        httpRequest.setAttribute("showSidebar", true);

        chain.doFilter(request, response);
    }
  
}