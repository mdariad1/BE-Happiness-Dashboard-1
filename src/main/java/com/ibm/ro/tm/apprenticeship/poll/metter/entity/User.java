/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.SortNatural;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author O09860826
 *
 */
@Entity
public class User implements Comparable<User> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Column
	private String role;

	protected User() {

	}

	public User(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the role
	 */
	public String getRole() { return role; }

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "(" + this.id + ", " + this.name + ", " + this.role + ")";
	}

	@Override
	public int compareTo(User o) {
		int result = 0;
		if (o != null) {
			if (id != null) {
				result = id.compareTo(o.getId());
			} else if (o.getId() != null) {
				result = 1;
			}else {
				result = 0;
			}
		} else {
			result = -1;
		}
		return result;
	}

}
