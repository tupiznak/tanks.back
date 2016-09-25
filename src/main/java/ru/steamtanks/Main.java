package ru.steamtanks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {
	/*
	private static final class Test<T>{
		String T;
		private Test(String T){
			this.T = T;
		}
		public String getT(){return T;}
	}*/
	public static void main(String[] args)
	{
		//Test a = new Test<>();
		SpringApplication.run(Main.class, args);
	}
}
