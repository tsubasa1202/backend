package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class JsonDAO2 {
	
	public static void main(String[] args) {
		try{
		JasonDAO dao = new JasonDAO();
		dao.insertData("news");
		}catch(DAOException e){
			e.printStackTrace();
		}
		
	}
	
	private Connection con;
	
    public void insertData(String articleId, String headLine, String newsLink, String thumbUrl, String categoryId, String categoryName, String mediaId, String mediaName, String createTime, String updateTime, String vespaIndex) throws DAOException {
        if (con == null) {
            con = JDBCManager.getConnection();
        }

        PreparedStatement st = null;
     
        try {
            // SQL文の作成
            String sql = "INSERT INTO  users(name)"
            		+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
            // PreparedStatementオブジェクトの取得
            st = con.prepareStatement(sql);
            st.setString(1, articleId);
            st.setString(2, headLine);
            st.setString(3, newsLink);
            st.setString(4, thumbUrl);
            st.setString(5, categoryId);
            st.setString(6, categoryName);
            st.setString(7, mediaId);
            st.setString(8, mediaName);
            st.setString(9, createTime);
            st.setString(10, updateTime);
            st.setString(11, vespaIndex);
          
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
    
    public void insertDataWithClick(String articleId, String headLine, String newsLink, String thumbUrl, String categoryId, String categoryName, String mediaId, String mediaName, String createTime, String updateTime, String vespaIndex, int click) throws DAOException {
        if (con == null) {
            con = JDBCManager.getConnection();
        }

        PreparedStatement st = null;
     
        try {
            // SQL文の作成
            String sql = "INSERT INTO  users(name)"
            		+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            // PreparedStatementオブジェクトの取得
            st = con.prepareStatement(sql);
            st.setString(1, articleId);
            st.setString(2, headLine);
            st.setString(3, newsLink);
            st.setString(4, thumbUrl);
            st.setString(5, categoryId);
            st.setString(6, categoryName);
            st.setString(7, mediaId);
            st.setString(8, mediaName);
            st.setString(9, createTime);
            st.setString(10, updateTime);
            st.setString(11, vespaIndex);
            st.setInt(12, click);
          
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
