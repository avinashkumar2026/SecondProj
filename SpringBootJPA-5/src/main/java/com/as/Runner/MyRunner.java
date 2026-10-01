package com.as.Runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.as.Service.ICollegeMng;
@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	ICollegeMng ser;
	@Override
	public void run(String... args) throws Exception {
//		ser.saveDataUsingParent();
		ser.deleteDataUsingStu();
	}

}
