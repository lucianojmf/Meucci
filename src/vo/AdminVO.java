package vo;

public class AdminVO extends ObjectVO {

	private String login;

	private String password;

	
	public AdminVO() {
	}

	public AdminVO(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public AdminVO(int id, String login, String password) {
		super(id);
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


        @Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("[");
		buffer.append("id = ");
		buffer.append(this.getId());
		buffer.append(", login = ");
		buffer.append(this.getLogin());
		buffer.append("]");
		return buffer.toString();
	}
}
