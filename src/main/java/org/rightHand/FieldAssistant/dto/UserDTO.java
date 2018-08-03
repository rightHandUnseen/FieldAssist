package org.rightHand.FieldAssistant.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.rightHand.FieldAssistant.validator.annotations.Equals;
import org.rightHand.FieldAssistant.validator.annotations.UniqueEmail;
import org.rightHand.FieldAssistant.validator.annotations.UniqueUsername;

import lombok.Data;

@Data
public class UserDTO {

	@NotNull
	@Min(6)
	@UniqueUsername
	private String username;
	@NotNull
	@Email
	@UniqueEmail
	private String email;
	@NotNull
	@Min(6)
	@Equals
	private String password;
	@NotNull
	@Min(6)
	private String repassword;
	
	
	
	public UserDTO() {
		
	}
	
	
	
	public UserDTO(@NotNull @Min(6) String username, @NotNull @Email String email, @NotNull @Min(6) String password,
			@NotNull @Min(6) String repassword) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.repassword = repassword;
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	
	
}
