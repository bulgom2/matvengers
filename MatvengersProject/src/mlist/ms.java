package mlist;

import java.sql.Blob;

public class ms {
	private String subj;
	private String name;
	private double star;
	private String addr;
	private String tel;
	private String url;
	private Blob v_img;
	private String userid;
	private String style;
	
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSubj() {
		return subj;
	}
	public void setSubj(String subj) {
		this.subj = subj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getStar() {
		return star;
	}
	public void setStar(double star) {
		this.star = star;
	}

	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Blob getV_img() {
		return v_img;
	}
	public void setV_img(Blob v_img) {
		this.v_img = v_img;
	}

	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	private String cmt;
	private String menu;
	public Blob getM_img() {
		return m_img;
	}
	public void setM_img(Blob m_img) {
		this.m_img = m_img;
	}
	private Blob m_img;
}
