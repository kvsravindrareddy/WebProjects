package com.ravindra.controller;

import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@RequestScoped
@ManagedBean(name="imageController")
public class ImageController {
	private StreamedContent myImage;
	
	public StreamedContent getMyImage() {
		return myImage;
	}
	public void setMyImage(StreamedContent myImage) {
		this.myImage = myImage;
	}

	public ImageController() {
		InputStream is = null;//input stream
		myImage = new DefaultStreamedContent(is,"image/png");
		
	}
	
}
