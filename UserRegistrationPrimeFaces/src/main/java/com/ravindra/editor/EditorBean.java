package com.ravindra.editor;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="editor")
public class EditorBean {
	private String value = "Hello world prime faces";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
