package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean overlappedID(String id){
		boolean result = false;
		try {
			con = dataFactory.getConnection();	// 디비 커넥션 
			String query = "select decode(count(*),1,'true','false') as result from t_member";
				   query += " where id=?";
			System.out.println("prepareStatememt: " + query); // 실행할 쿼리 출력
			
			pstmt = con.prepareStatement(query);	// 문장객체?
			
			pstmt.setString(1, id);					// 파라미터 setting
			
			ResultSet rs = pstmt.executeQuery();	// 쿼리 실행
			
			rs.next();								// 첫번째 결과
			result =Boolean.parseBoolean(rs.getString("result"));	// 결과를 Boolean으로 형변환 
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
