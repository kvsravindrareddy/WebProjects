package com.ravindra.controller;

import javax.faces.bean.ManagedBean;

import com.ravindra.common.SendSMSToMobile;

@ManagedBean(name="smsController")
public class SMSController {
	private String visitorContactNum;
	private String smsText;
	private String visitorName;

	public String getVisiterContactNum() {
		return visitorContactNum;
	}
	public void setVisiterContactNum(String visitorContactNum) {
		this.visitorContactNum = visitorContactNum;
	}
	public String getSmsText() {
		return smsText;
	}
	public void setSmsText(String smsText) {
		this.smsText = smsText;
	}

	public String getVisitorName() {
		return visitorName;
	}
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}
	public String sendSMS() {
		SendSMSToMobile sms = new SendSMSToMobile();
		sms.sendSMS(this.getVisiterContactNum(), this.getVisitorName(), this.getSmsText());
		return "success";
	}
}
