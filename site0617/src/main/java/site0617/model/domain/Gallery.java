package site0617.model.domain;

public class Gallery {
	private int gallaery_id;
	private String title;
	private String writer; 
	private String content;
	private String regdate;
	private String filename;
	private int hit;
	public int getGallaery_id() {
		return gallaery_id;
	}
	public void setGallaery_id(int gallaery_id) {
		this.gallaery_id = gallaery_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
	
	
}
