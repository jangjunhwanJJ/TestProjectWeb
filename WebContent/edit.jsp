<%@page import="www.jcc.com.control.BoardControl"%>
<%@page import="www.jcc.com.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	request.setCharacterEncoding("UTF-8");
	String title=request.getParameter("title");
	String writer=request.getParameter("writer");
	String content=request.getParameter("content");
	int id=Integer.parseInt(request.getParameter("id"));
	
	Board board= new Board();
	board.setTitle(title);
	board.setWriter(writer);
	board.setContent(content);
	board.setId(id);
	
	BoardControl control = new BoardControl();
	int result = control.updateBoard(board);
	
	out.print("result:"+result);
	
	
%>