package com.ravindra.controller;

import javax.faces.bean.ManagedBean;

import com.ravindra.common.SendMailTLS;
//Email Controller to send email to user
@ManagedBean(name="emailController")
public class EmailController {
	private String visitorName;
	private String visitorMobileNumber;
	private String msg;
	private String visitorEmail;
	
	public String getVisitorName() {
		return visitorName;
	}
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}
	public String getVisitorMobileNumber() {
		return visitorMobileNumber;
	}
	public void setVisitorMobileNumber(String visitorMobileNumber) {
		this.visitorMobileNumber = visitorMobileNumber;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getVisitorEmail() {
		return visitorEmail;
	}
	public void setVisitorEmail(String visitorEmail) {
		this.visitorEmail = visitorEmail;
	}
	
	public String sendEnquiryEmail() {
		SendMailTLS email = new SendMailTLS();
		email.enquiryEmail(this.getVisitorName(), this.getVisitorMobileNumber(), this.getVisitorEmail(), this.getMsg());
		email.acknowledgementToVisitor(this.getVisitorName(), this.getVisitorEmail());
		return "success";
	}
}
