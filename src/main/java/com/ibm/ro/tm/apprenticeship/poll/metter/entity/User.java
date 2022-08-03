/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Column
	private String role;

	@Column
	private String login;

	@Column
	private String password;



	@JsonIgnore
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<Poll> polls;

	@JsonIgnore
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<Answer> answers;

	public User() {

	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role){
		this.role = role;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login){
		this.login = login;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "(" + this.id + ", " + this.name + ", " + this.role + ")";
	}

}
