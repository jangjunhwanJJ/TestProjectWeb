<%@page import="www.jcc.com.control.BoardControl"%>
<%@page import="www.jcc.com.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String param1 = request.getParameter("title");
String param2 = request.getParameter("writer");
String param3 = request.getParameter("content");

Board board = new Board();
board.setTitle(param1);
board.setWriter(param2);
board.setContent(param3);

out.print(board.toString());

BoardControl control = new BoardControl();
int result = control.insert(board);

%>