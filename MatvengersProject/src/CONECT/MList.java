package CONECT;

import java.sql.Blob;

public class MList {
	private String  name;
	private String addr;
	private String tel;
	private String url;
	private Blob m_img;
	private Blob v_img;
	private String subj;
	private String style;
	private String menu;
	private int price;
	private String userid;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Blob getM_img() {
		return m_img;
	}
	public void setM_img(Blob m_img) {
		this.m_img = m_img;
	}
	public Blob getV_img() {
		return v_img;
	}
	public void setV_img(Blob v_img) {
		this.v_img = v_img;
	}
	public String getSubj() {
		return subj;
	}
	public void setSubj(String subj) {
		this.subj = subj;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "mlist [name=" + name + ", addr=" + addr + ", tel=" + tel + ", url=" + url + ", m_img=" + m_img
				+ ", v_img=" + v_img + ", subj=" + subj + ", style=" + style + ", menu=" + menu + ", price=" + price
				+ ", userid=" + userid + "]";
	}
	
}
