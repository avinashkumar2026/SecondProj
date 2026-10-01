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
@Table(name="JPA_Faculty")
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Faculty {
	@Id
	@SequenceGenerator(name="gen1",sequenceName="FID_SEQ", initialValue=1,allocationSize=1)
	@GeneratedValue(generator="gen1", strategy=GenerationType.SEQUENCE)
	private int fid;
	@NonNull
	@Column(length=20)
	private String fname;
	@NonNull
	@Column(length=20)
	private String fadd;
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Student> studentInfo = new HashSet();
	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", fadd=" + fadd + "]";
	}
	
}
