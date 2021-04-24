package com.work.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private int requestCount;
	static {
		System.out.println("1. class loading : 변경");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleServlet() {
    	System.out.println("2. new instance : 변경");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		//임의로 예외 발생
		/*
		 * if (true) { throw new NullPointerException("초기화 수행시에 예외가 발생되었습니다."); }
		 */
		System.out.println("3. init()초기화 수행 : 변경");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("5. destroy()");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestCount++;
		System.out.println("4. service() : 변경" + requestCount);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestCount++;
		System.out.println("4. doget() : 변경" + requestCount);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestCount++;
		System.out.println("4. doPost() : 변경" + requestCount);
	}

}
