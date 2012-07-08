package org.krams.domain;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = -4093981756240899937L;
	private String senderName;
	private String senderEmail;
	private String ccEmail;
	private String subject;
	private String body;
	private String receiverName;
	private String receiverEmail;
	private String filename;
	
	public Message() {
		super();
	}
	
	public Message(String senderName, String senderEmail, String ccEmail,
			String subject, String body, String receiverName,
			String receiverEmail, String filename) {
		super();
		this.senderName = senderName;
		this.senderEmail = senderEmail;
		this.ccEmail = ccEmail;
		this.subject = subject;
		this.body = body;
		this.receiverName = receiverName;
		this.receiverEmail = receiverEmail;
		this.filename = filename;
	}
	
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	public String getCcEmail() {
		return ccEmail;
	}
	public void setCcEmail(String ccEmail) {
		this.ccEmail = ccEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverEmail() {
		return receiverEmail;
	}
	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "Message [senderName=" + senderName + ", senderEmail="
				+ senderEmail + ", ccEmail=" + ccEmail + ", subject=" + subject
				+ ", body=" + body + ", receiverName=" + receiverName
				+ ", receiverEmail=" + receiverEmail + ", filename=" + filename
				+ "]";
	}
	
}
