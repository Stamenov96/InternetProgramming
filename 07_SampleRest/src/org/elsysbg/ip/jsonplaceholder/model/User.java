package org.elsysbg.ip.jsonplaceholder.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity(name="Users")
@NamedQueries({
	@NamedQuery(name = "userByEmail", 
			query = "SELECT u from Users u where u.email=:email"),
	@NamedQuery(name = "usersByLikedPost", 
			query = "SELECT u from Users u where (:likedPost) MEMBER OF u.likedPosts")
})
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false, length=50, unique=true)
	private String email;
	
	@Column(nullable=false)
	// store enum as string, not as integer
	@Enumerated(EnumType.STRING)
	private Role role = Role.USER;
	
	@ManyToMany(mappedBy="likedByUsers")
	private Set<Post> likedPosts = new HashSet<Post>();
	
	@Column(nullable=false, length=50)
	private String password;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@XmlTransient
	// Password is a secret and
	// must not be send to the client
	public String getPassword() {
		return password;
	}
	@XmlElement
	// User should be able to set its own password
	// XmlElement is required because of XmlTransient in the getter 
	public void setPassword(String password) {
		this.password = password;
	}

	@XmlTransient
	public Set<Post> getLikedPosts() {
		return likedPosts;
	}
	public void setLikedPosts(Set<Post> likedPosts) {
		this.likedPosts = likedPosts;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
}
