package backend;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.DAOException;
import dao.JasonDAO;

import com.fasterxml.jackson.core.type.TypeReference;

public class JsonReader {

	public static void main(String[] args) {

		JasonDAO dao = new JasonDAO();

		//最新記事取得API
		String url = "http://www.hugkey.com/test/20131127/api/getDataAPI";
		ArrayList<UserBean> bean = makeJavaObject(makeJsonString(url));

		try{
			for(int i=0; i<bean.size(); i++){
				dao.insertData(bean.get(i).getName());
				System.out.println(bean.get(i));
			}
		}catch(DAOException e){
			e.printStackTrace();
		}
	}

	public static String makeJsonString(String url){

		String line = "";
		String json = "";

		try{
			URL apiUrl=new URL(url);
			BufferedReader reader = new BufferedReader(new InputStreamReader(apiUrl.openStream(), "UTF-8"));
			while((line = reader.readLine()) != null){
				json+=line;
			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return json;

	}

	public static ArrayList<UserBean> makeJavaObject(String json){
		ArrayList<UserBean> user = new ArrayList<UserBean>() ;

		try{
			user = new ObjectMapper().readValue(json, new TypeReference<ArrayList<UserBean>>() {});
			System.out.println(json);
			for(int i=0; i<user.size(); i++){
				System.out.println(user.get(i).getName() + " " + user.get(i).getAddress());
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return user;


	}
}