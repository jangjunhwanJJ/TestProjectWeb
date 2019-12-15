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

}
