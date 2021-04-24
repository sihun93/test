package com.work.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginFormServlet
 */
public class LoginFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * >> forward : 기존 설정 데이터를 가지고 새로운 페이지 이동(기존 정보 유지)
		>> redirect : 기존 정보를 버리고 새로운 페이지 이동(기존 정보 사용 불기)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

}
