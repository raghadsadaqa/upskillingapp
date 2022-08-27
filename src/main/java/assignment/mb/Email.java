package assignment.mb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import assignment.bean.Program;
import assignment.bean.School;
import assignment.bean.Student;
import assignment.bean.University;
import assignment.dao.ProgramDAO;
import assignment.dao.SchoolDAO;
import assignment.dao.UniDAO;
import database.Database;

public class Email {

	/*
	 * private static Database db = new Database(); static Connection connection =
	 * db.getConnection(); static PreparedStatement ps =
	 * connection.prepareStatement("select email from student where student_id = ?"
	 * ); static ResultSet rs = ps.executeQuery();
	 */

	private String email;
	private Student student = new Student(email);
	private static String USER_NAME = "" ;  // GMail user name (just the part before "@gmail.com")
	private static String PASSWORD = "********"; // GMail password
	private static String RECIPIENT = "lizard.bill@myschool.edu";

	public static void main(String[] args) {
		String from = USER_NAME;
		String pass = PASSWORD;
		String[] to = { RECIPIENT }; // list of recipient email addresses
		String subject = "Java send mail example";
		String body = "Welcome to JavaMail!";

		sendFromGMail(from, pass, to, subject, body);
	}

	private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(from));
			InternetAddress[] toAddress = new InternetAddress[to.length];

			// To get the array of addresses
			for (int i = 0; i < to.length; i++) {
				toAddress[i] = new InternetAddress(to[i]);
			}

			for (int i = 0; i < toAddress.length; i++) {
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}

			message.setSubject(subject);
			message.setText(body);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
	}

}
