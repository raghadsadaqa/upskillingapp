package assignment.mb;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import util.Message;

@ManagedBean(name = "mbLog")
@SessionScoped
public class MBLogin {

	private String username;
	private String password;
	private boolean logon;

	private String lang = "en";
	private Locale locale = Locale.ENGLISH;
	private String dir = "ltr";
	private static Map<String, Object> countries;

	static {
		countries = new LinkedHashMap<String, Object>();
		countries.put("English", Locale.ENGLISH);
		countries.put("عربي", new Locale("ar"));
		countries.put("Türkçe", new Locale("tr"));
	}

	public void localeChanged(ValueChangeEvent e) {
		lang = e.getNewValue().toString();
		for (Map.Entry<String, Object> entry : countries.entrySet()) {
			if (entry.getValue().toString().equals(lang)) {
				locale = lang.equals("en") ? Locale.ENGLISH : new Locale(lang);
				FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
				dir = lang.equals("ar") ? "rtl" : "ltr";
			}
		}
	}

	public String checkUser() {
		if ((username.equalsIgnoreCase("htu") && password.equals("htu@1"))
				|| (username.equalsIgnoreCase("java") && password.equals("Java@2022"))) {
			logon = true;
			return "/screen.xhtml";
		} else {
			logon = false;
			Message.addMessage("ERROR", " ", "please check your usernsme or password");
			return null;
		}
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/screen.xhtml?faces-redirect=true";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLogon() {
		return logon;
	}

	public void setLogon(boolean logon) {
		this.logon = logon;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Locale getLocale() {
		return locale;
	}

	public String getDir() {
		return dir;
	}

	public Map<String, Object> getCountries() {
		return countries;
	}

}
