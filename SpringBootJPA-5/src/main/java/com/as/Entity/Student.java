package com.as.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="JPA-STUDENT")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {
	@Id
	@SequenceGenerator(name="gen1",sequenceName="SID_SEQ", initialValue=100,allocationSize=1)
	@GeneratedValue(generator="gen1", strategy=GenerationType.SEQUENCE)
	private int sid;
	@NonNull
	@Column(length=20)
	private String sname;
	@NonNull
	@Column(length=20)
	private String sadd;
	@NonNull
	@Column(length=20)
	private String college;
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="studentInfo")
	private Set<Faculty> facultyInfo = new HashSet();
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sadd=" + sadd + ", college=" + college + 
		        "]";
	}
	
}
