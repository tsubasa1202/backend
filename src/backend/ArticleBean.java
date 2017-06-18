package backend;

public class ArticleBean {
	
	private String articleId;
	private String headLine;
	private String newsLink;
	private String thumbUrl;
	private String categoryId;
	private String categoryName;
	private String mediaId;
	private String mediaName;
	private String createTime;
	private String updateTime;
	private String vespaIndex;
	private int click;
	
	
	public ArticleBean(){
		
	}


	public String getArticleId() {
		return articleId;
	}


	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}


	public String getHeadLine() {
		return headLine;
	}


	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}


	public String getNewsLink() {
		return newsLink;
	}


	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}


	public String getThumbUrl() {
		return thumbUrl;
	}


	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}


	public String getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getMediaId() {
		return mediaId;
	}


	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}


	public String getMediaName() {
		return mediaName;
	}


	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}


	public String getCreateTime() {
		return createTime;
	}


	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	public String getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}


	public String getVespaIndex() {
		return vespaIndex;
	}


	public void setVespaIndex(String vespaIndex) {
		this.vespaIndex = vespaIndex;
	}


	public int getClick() {
		return click;
	}


	public void setClick(int click) {
		this.click = click;
	}
	
	
	
	

}
