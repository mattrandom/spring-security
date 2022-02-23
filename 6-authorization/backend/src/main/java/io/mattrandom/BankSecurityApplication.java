package io.mattrandom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootApplication
public class BankSecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BankSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String pw_hash = BCrypt.hashpw("qwerty", BCrypt.gensalt());
		System.out.println(pw_hash);
		boolean check_pw = BCrypt.checkpw("qwerty", pw_hash);
		System.out.println(pw_hash + " = qwerty = " + check_pw);
	}
}
