package com.as.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.Entity.Faculty;
import com.as.Entity.Student;
import com.as.Repository.IFacultyRepo;
import com.as.Repository.IStudentRepo;

@Service
public class ImpCollegeMng implements ICollegeMng {

	@Autowired
	IStudentRepo stdRepo;
	@Autowired
	IFacultyRepo facRepo;
	@Override
	public void saveDataUsingParent() {
		//student obj data
		Student s1 = new Student("Alen","south","CU");
		Student s2 = new Student("Alas","north","CU");
		Student s3 = new Student("Avi","east","CU");
		//faculty obj data
		Faculty f1 = new Faculty("Dviya","Gaya");
		Faculty f2 = new Faculty("Raghav","Delhi");
		//student ka data faculty ke ander set me
		f1.getStudentInfo().add(s1);
		f1.getStudentInfo().add(s2);
		f1.getStudentInfo().add(s3);
		f2.getStudentInfo().add(s1);
		f2.getStudentInfo().add(s2);
		
		s1.getFacultyInfo().add(f1);
		s1.getFacultyInfo().add(f2);
		s2.getFacultyInfo().add(f1);
		s2.getFacultyInfo().add(f2);
		s3.getFacultyInfo().add(f2);
		
		facRepo.save(f1);
		facRepo.save(f2);
		System.out.println("Faculty and Student data are saved");

	}
	@Override
	public void deleteDataUsingStu() {
		Optional obj = stdRepo.findById(100);
		
		if(obj.isPresent()) {
			System.out.println(obj.getClass().getName());
			Student s =(Student) obj.get();
			Set<Faculty> f = s.getFacultyInfo();
			s.setFacultyInfo(null);
			f.forEach(fnew->{fnew.setStudentInfo(null);});
			stdRepo.save(s);
			System.out.println("Stduent is removes");
		}
		else
			System.out.println("Not found ");
	}

}
