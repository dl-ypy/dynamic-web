package com.shixun.kecheng;

public class Yhk {
	private String kc_id = null;
	private String kc_name = null;
	private String kc_address = null;
	private String th_id = null;
	public String getTh_id() {
		return th_id;
	}
	public void setTh_id(String th_id) {
		this.th_id = th_id;
	}
	public String getKc_address() {
		return kc_address;
	}
	public void setKc_address(String kc_address) {
		this.kc_address = kc_address;
	}
	public static final int page_size = 5;
	public String getKc_id() {
		return kc_id;
	}
	public void setKc_id(String kc_id) {
		this.kc_id = kc_id;
	}
	public String getKc_name() {
		return kc_name;
	}
	public void setKc_name(String kc_name) {
		this.kc_name = kc_name;
	}
}
