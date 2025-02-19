package com.example.springtodomanagement.Service.Impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PassEncode 
{
	public static void main(String[] args) {
		
		
		PasswordEncoder penc=new BCryptPasswordEncoder();
		
		System.out.println(penc.encode("naveen"));
		System.out.println(penc.encode("admin"));
		
		}
	
	
}
