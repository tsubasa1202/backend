package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class JasonDAO {
	
	public static void main(String[] args) {
		try{
		JasonDAO dao = new JasonDAO();
		dao.insertData("news");
		}catch(DAOException e){
			e.printStackTrace();
		}
		
	}
	
	private Connection con;
	
    public void insertData(String name) throws DAOException {
        if (con == null) {
            con = JDBCManager.getConnection();
        }

        PreparedStatement st = null;
     
        try {
            // SQL文の作成
            String sql = "INSERT INTO  users(name)"
            		+ "values(?)";
            // PreparedStatementオブジェクトの取得
            st = con.prepareStatement(sql);
            st.setString(1, name);

            // SQLの実行
            st.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("レコードの取得に失敗しました。");
        } finally {
            try {
                // リソースの開放
                if(st != null) st.close();
            } catch (Exception e) {
                throw new DAOException("リソースの開放に失敗しました。");
            }
        }
    }

}
