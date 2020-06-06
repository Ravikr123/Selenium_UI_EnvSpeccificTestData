package com.hpi.Utility;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.testng.Reporter;

public class SendFileEmail {
	
	String smtpServer = "smtp-americas.hp.com";
	//String toAddress = null;
	String fromAddress = "press-care@hp.com";
	String subject = "PrintOS Service Centre UI Automation Report:-";
	String body = "Hello All, \r\n" + 
			"\r\n" + 
			"Please find the attached generated detailed reports.\r\n" + 
			"\r\n" + 
			" Thanks, \r\n" + 
			" Automation Team\r\n" + 
			"";
	String filename1 = ExtentManager.htmlReportPath();
	
	public SendFileEmail(){
		super();
	}
	
	public void setMailWithAttachmentParams(String smtpServer,String toAddress, String fromAddress, String subject,String body, String filename1)
	{
		this.smtpServer=smtpServer;
		//this.toAddress = toAddress;
		this.fromAddress = fromAddress;
		this.subject = subject;
		this.body = body;
		this.filename1 = filename1;
	}
	
	public boolean sendMailWithAttachmentNew(String filename1,String env, String toAddress)
	{
			try
			{
				//Set the host smtp address
				Properties props = new Properties();
				props.put("mail.transport.protocol","smtp");
			    props.put("mail.smtp.auth", "false");
				props.put("mail.smtp.host",smtpServer );
				//get the default Session
				Session session = Session.getDefaultInstance(props);
				//Create a message
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(fromAddress));
				//Adding multiple recipients
				InternetAddress[] toAddressArray = InternetAddress.parse(toAddress);			
				message.addRecipients(Message.RecipientType.TO, toAddressArray);			
				message.setSubject(subject + env);
				// Create the message part 
				BodyPart messageBodyPart = new MimeBodyPart();
				// Fill the message
				messageBodyPart.setText(body);
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(messageBodyPart);		
				// Part two is attachment, attach detailed report
				messageBodyPart = new MimeBodyPart();
				Reporter.log( "attached detailed report :" + filename1);			
				DataSource source = new FileDataSource(filename1);			
				messageBodyPart.setDataHandler(new DataHandler(source));	
				messageBodyPart.setFileName(filename1.substring(filename1.lastIndexOf(File.separator)+1,filename1.length()));
				multipart.addBodyPart(messageBodyPart);

				// Put parts in message
				message.setContent(multipart);
	
				// Send the message
				Transport transport = session.getTransport();
				transport.connect();
				transport.send(message, message.getAllRecipients());
				//Transport.send(message);
				return true;
			}
			catch (SendFailedException sfe)
			{
				sfe.printStackTrace();				
				return false;
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				return false;
			}

		}

}
