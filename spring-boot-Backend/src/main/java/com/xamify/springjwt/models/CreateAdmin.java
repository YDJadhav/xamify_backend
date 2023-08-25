package com.xamify.springjwt.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "add_collegeadmin")
public class CreateAdmin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "collegeadminname")
	private String collegeadminname;
	@Column(name = "collegeadminid")
	private String collegeadminid;
	@Column(name = "collegeid")
	private String collegeid;
	
	@Column(name = "adminStatus")
	private String adminStatus;
	@CreationTimestamp
	private LocalDateTime dateCreated;
	@UpdateTimestamp
	private LocalDateTime dateUpdated;

	public CreateAdmin(String collegeadminname, String collegeid, String collegeadminid,
			String adminStatus) {
		this.collegeadminname = collegeadminname;
		this.collegeadminid = collegeadminid;
		this.collegeid = collegeid;
		this.adminStatus = adminStatus;

	}

	public long getId() {
		return id;
	}

	public String getcollegeadminname() {
		return collegeadminname;
	}

	public void setcollegeadminname(String collegeadminname) {
		this.collegeadminname = collegeadminname;
	}

	public String getcollegeid() {
		return collegeid;
	}

	public void setCollegeid(String collegeid) {
		this.collegeid = collegeid;
	}

	public String getcollegeadminid() {
		return collegeadminid;
	}

	public void setcollegeadminid(String collegeadminid) {
		this.collegeadminid = collegeadminid;
	}

	

	public String getadminStatus() {
		return adminStatus;
	}

	public void setadminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

	@Override
	public String toString() {
		return "Tutorial [collegeadminname=" + collegeadminname + ", collegeid=" + collegeid + ", collegeadminid=" + collegeadminid
			 + ",adminstatus=" + adminStatus + "]";
	}

}
