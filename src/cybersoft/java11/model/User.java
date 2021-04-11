package cybersoft.java11.model;

public class User {
	/*
	 * Tạo đối tượng useser có các thông tin sau: - họ và tên - năm sinh - username
	 * - Mật khẩu - Chức vụ -
	 * 
	 * - Viết các lớp controller có các chức năng: Lấy ra danh sách user Tạo mới
	 * user - Cập nhận thông tin user - Xóa user
	 */
	private String hoVaTen;
	private int namSinh;
	private String username;
	private String password;
	private int chucVu;

	/*
	 * CONSTRUCTORS
	 */

	public User(String hoVaTen, int namSinh, String username, String password, int chucVu) {
		this.hoVaTen = hoVaTen;
		this.namSinh = namSinh;
		this.username = username;
		this.password = password;
		this.chucVu = chucVu;
	}

	public User() {
		this.hoVaTen = "";
		this.namSinh = 1900;
		this.username = "";
		this.password = "";
		this.chucVu = 1;
	}

	/*
	 * GETTER SETTER METHODS
	 */
	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
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

	public int getChucVu() {
		return chucVu;
	}

	public void setChucVu(int chucVu) {
		this.chucVu = chucVu;
	}

}
