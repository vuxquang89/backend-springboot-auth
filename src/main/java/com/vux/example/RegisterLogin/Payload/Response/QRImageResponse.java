package com.vux.example.RegisterLogin.Payload.Response;


public class QRImageResponse {

	private long id;
	private String uri;
	private String uriResize;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getUriResize() {
		return uriResize;
	}
	public void setUriResize(String uriResize) {
		this.uriResize = uriResize;
	}
	
}
