package com.work.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * -- 1. 요청객체에 대한 한글 인코딩 설정 : utf-8
	>>request.setCharacterEncoding("utf-8");
-- 2. 요청시에 전달받은 요청데이타 가져오기
	>> view form 입력항목에 name="key"
	java.lang.String	getParameter(java.lang.String name) : 해당 요청 데이터 단일값
	java.util.Map<java.lang.String,java.lang.String[]>	getParameterMap() : 전체 요청데이터 
	java.util.Enumeration<java.lang.String>	getParameterNames() : 전체 요청데이터에 대한 name
	java.lang.String[]	getParameterValues(java.lang.String name) : 해당 요청데이터 다중값

	>>form 입력항목 다중값 : checkbox, multiple로 지정한 select

-- 3. 응답을 위한 mime-type 및 한글 인코딩 설정
	>>response.setContentType(text/html; charset=UTF-8);

-- 4. 응답을 위한 출력 스트림 객체 : text/html => character단위 출력스트림
	>> 	java.io.PrintWriter	getWriter() : character 단위 출력스트림
	>>	ServletOutputStream	getOutputStream() : byte 단위 출력스트림

-- 5. 응답 출력스트림 객체를 통해서 html 동적 페이지 응답 출력스트림
	>> out.println("<html><head></head><body><h3>...</h3></body></html>"); => jsp로 만들것

-- 6. 응답 출력 스트림 자원 해제
	>> out.close();	
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인 요청 서비스 서블릿");
		//요청 인코딩 한글설정
		request.setCharacterEncoding("utf-8");
		//요청시에 전달받은 요청데이타 가져오기
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String message = null;
		// 아이디가 user01, 비밀번호가 password01 : 로그인성공
		// 아니면 실패 message 변수 설정
		if (memberId.equals("user01")) {
			if (memberPw.equals("password01")) {
				message = "로그인 성공";
			}else {
				message = "비밀번호가 틀렸습니다.";
			}
		}else {message = "없는 아이디 입니다.";}
		
		//응답을 위한 mime-type 및 한글 인코딩 설정
		response.setContentType("text/html; charset=utf-8");
		//응답을 위한 출력 스트림 객체 : text/html => character단위 출력스트림
		PrintWriter out = response.getWriter();
		//응답 출력스트림 객체를 통해서 html 동적 페이지 응답 출력스트림
		out.println("<html><head>로그인결과</head><body>");
		out.println("<h3> " + message + "</h3>");
		out.print("</body></html>");
		//응답 출력 스트림 자원 해제
		out.close();
	}

}
