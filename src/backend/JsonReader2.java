package backend;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.DAOException;
import dao.JsonDAO2;

import com.fasterxml.jackson.core.type.TypeReference;

public class JsonReader2 {

	public static void main(String[] args) {

		JsonDAO2 dao = new JsonDAO2();

		//最新記事取得API
		String newArticleAPI = "http://www.hugkey.com/test/20131127/api/getDataAPI";
		ArrayList<ArticleBean> newArticleBean = makeJavaObject(makeJsonString(newArticleAPI));

		try{
			for(int i=0; i<newArticleBean.size(); i++){
				String detailArticleAPI = "http://www.hugkey.com/test/20131127/api/getDataAPI?id=" + newArticleBean.get(i).getCategoryId();
				ArrayList<ArticleBean> detailArticleBean = makeJavaObject(makeJsonString(detailArticleAPI));
				
				dao.insertData(detailArticleBean.get(i).getArticleId(), detailArticleBean.get(i).getHeadLine(), detailArticleBean.get(i).getNewsLink(), detailArticleBean.get(i).getThumbUrl(), detailArticleBean.get(i).getCategoryId(), detailArticleBean.get(i).getCategoryName(), detailArticleBean.get(i).getMediaId(), detailArticleBean.get(i).getMediaName(), detailArticleBean.get(i).getCreateTime(), detailArticleBean.get(i).getUpdateTime(), detailArticleBean.get(i).getVespaIndex() );
				
			}
		}catch(DAOException e){
			e.printStackTrace();
		}
		
		//人気記事取得API
		String popularArticleAPI = "http://www.hugkey.com/test/20131127/api/getDataAPI";
		ArrayList<ArticleBean> popularArticleBean = makeJavaObject(makeJsonString(popularArticleAPI));

		try{
			for(int i=0; i<popularArticleBean.size(); i++){
				String detailArticleAPI = "http://www.hugkey.com/test/20131127/api/getDataAPI?id=" + popularArticleBean.get(i).getCategoryId();
				ArrayList<ArticleBean> detailArticleBean = makeJavaObject(makeJsonString(detailArticleAPI));
				dao.insertDataWithClick(detailArticleBean.get(i).getArticleId(), detailArticleBean.get(i).getHeadLine(), detailArticleBean.get(i).getNewsLink(), detailArticleBean.get(i).getThumbUrl(), detailArticleBean.get(i).getCategoryId(), detailArticleBean.get(i).getCategoryName(), detailArticleBean.get(i).getMediaId(), detailArticleBean.get(i).getMediaName(), detailArticleBean.get(i).getCreateTime(), detailArticleBean.get(i).getUpdateTime(), detailArticleBean.get(i).getVespaIndex(), popularArticleBean.get(i).getClick());
				
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

	public static ArrayList<ArticleBean> makeJavaObject(String json){
		ArrayList<ArticleBean> user = new ArrayList<ArticleBean>() ;

		try{
			user = new ObjectMapper().readValue(json, new TypeReference<ArrayList<ArticleBean>>() {});
			System.out.println(json);
		
		}catch(Exception e){
			e.printStackTrace();
		}

		return user;


	}
}