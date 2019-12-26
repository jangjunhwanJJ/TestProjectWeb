package www.jcc.com.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import www.jcc.com.db.DBConn;
import www.jcc.com.vo.Board;

public class BoardControl {

	public List<Board> selectBoardList(Board board){
		List<Board> result = new ArrayList<Board>();
		DBConn db = new DBConn();
		try (Connection conn= db.getConnection()){
			StringBuilder sql= new  StringBuilder();
			sql.append("SELECT id,title,writer,content,wdate FROM Board");
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Board item = new Board();
				item.setId(rs.getInt("id"));
				item.setTitle(rs.getString("title"));
				item.setWriter(rs.getString("writer"));
				item.setContent(rs.getString("content"));
				item.setWdate(rs.getString("wdate"));

				result.add(item);

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int insert(Board board) {
		int result = 0;
		DBConn db= new DBConn();

		try (Connection conn= db.getConnection()){
			StringBuilder sql= new StringBuilder();
			sql.append("INSERT INTO Board(title, writer, content) ")
			.append("VALUES (?,?,?)");
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());

			System.out.println(pstmt.toString());

			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();

		}catch(ClassNotFoundException e)	{
			e.printStackTrace();
		}

		return result;
	}
	public Board selectOne(Board param) {
		Board result = new Board();

		DBConn db = new DBConn();

		try (Connection conn= db.getConnection()){
			StringBuilder sql= new StringBuilder();
			sql.append("Select * FROM Board WHERE id=?");

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, param.getId());
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				result.setId(rs.getInt("id"));
				result.setTitle(rs.getString("title"));
				result.setWdate(rs.getString("wdate"));
				result.setContent(rs.getString("Content"));
				result.setWriter(rs.getString("writer"));
			}

		}catch(SQLException e) {
			e.printStackTrace();

		}catch(ClassNotFoundException e)	{
			e.printStackTrace();
		}



		return result;
	}
	public int updateBoard (Board param) {
		int result = 0;
		DBConn db= new DBConn();

		try (Connection conn= db.getConnection()){
			StringBuilder sql= new StringBuilder();
			sql.append("UPDATE Board SET title=?,content=?,writer=? WHERE id=? ");

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, param.getTitle());
			pstmt.setString(2, param.getWriter());
			pstmt.setString(3, param.getContent());
			pstmt.setInt(4,param.getId());


			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();

		}catch(ClassNotFoundException e)	{
			e.printStackTrace();
		}

		return result;
	}
}
