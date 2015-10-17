package com.ravindra.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Call;
import com.twilio.sdk.resource.instance.Message;

public class SendSMSToMobile {
	private static final Logger logger = Logger.getLogger(SendSMSToMobile.class);
	public static final String ACCOUNT_SID = "AC709694c2265eb2305ef19c7eb1db6111";
	public static final String AUTH_TOKEN = "7412e83b400168f312ed6fa68a6a3fa0";

	public static TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

	public static Account account = client.getAccount();
	static Properties props = new Properties();
	StringBuilder sb = new StringBuilder();

	public void sendSMS(String visitorContactNum, String visitorName, String msgTxt) {  
		String smsMessage = sb.append(visitorContactNum).append(" Name : ").append(visitorName)
				.append(msgTxt).toString();
		MessageFactory messageFactory = account.getMessageFactory();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("To", "+91-9986002882")); 
		params.add(new BasicNameValuePair("From", "+13343842785"));
		params.add(new BasicNameValuePair("Body", smsMessage));
		try {
			Message sms = messageFactory.create(params);
			logger.info("**********sms sent from user***********"+visitorContactNum);
		} catch (TwilioRestException e) {
			e.printStackTrace();
		}
	}

	public static void callMobile() {
		CallFactory call = account.getCallFactory();
		Map<String, String> map = new HashMap<String, String>();
		map.put("To", "+91-9986002882");
		map.put("From", "+13343842785");
		map.put("Url", "http://demo.twilio.com/welcome/voice/");
		Call c;
		try {
			c = call.create(map);
			System.out.println(c.getSid());
		} catch (TwilioRestException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//		SendSMSToMobile.sendSMS("Hello Test....");
	}
}