package cybersoft.java11.model;

public class User {
	/*
	 * Tạo đối tượng useser có các thông tin sau: - họ và tên - năm sinh - username
	 * - Mật khẩu - Chức vụ -
	 * 
	 * - Viết các lớp controller có các chức năng: Lấy ra danh sách user Tạo mới
	 * user - Cập nhận thông tin user - Xóa user
	 */
	private String username;
	private String password;
	private String fullname;
	private int role;
	private int yearofbirth;

	/*
	 * CONSTRUCTORS
	 */
	public User(String username, String password, String fullname, int role, int yearofbirth) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.role = role;
		this.yearofbirth = yearofbirth;
	}
	/*
	 * GETTER SETTER METHODS
	 */

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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getYearofbirth() {
		return yearofbirth;
	}

	public void setYearofbirth(int yearofbirth) {
		this.yearofbirth = yearofbirth;
	}

}
