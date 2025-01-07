package validation.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class User {
	/**
	 * Spring Validation은 제약 조건을 선언한 순서에 따라 유효성 검사를 실행하지 않는다. 
	 * 대신, 각 제약 조건의 논리적 우선순위나 구현에 따라 다르다. 일반적으로, 빈 값이나 null 체크와 관련된 어노테이션(@NotNull, @NotEmpty, @NotBlank)이 먼저 실행된다.
	 */
	@NotEmpty
	@Size(min = 2, max = 8)
	private String name;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Size(min = 4, max = 8)
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
}
