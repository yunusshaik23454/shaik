package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		ServletContext ctx=getServletContext();
		String city=ctx.getInitParameter("city");
		String state=ctx.getInitParameter("state");
		pw.println("Servlet1:"+city+""+state);
		String str=city+state;
		ctx.setAttribute("information", str);
		ServletConfig cfg=getServletConfig();
		String user=cfg.getInitParameter("user");
		pw.println("<a href='Servlet2'>Nextpage</a>");
	}

}
