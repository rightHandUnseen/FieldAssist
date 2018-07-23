package org.rightHand.FieldAssistant;

public class Teste {

	public static void main(String[] args) {
		org.springframework.security.crypto.password.PasswordEncoder encoder
		   = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
		System.out.println(encoder.encode("teste"));

	}

}
