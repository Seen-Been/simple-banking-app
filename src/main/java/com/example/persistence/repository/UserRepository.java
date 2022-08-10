package com.example.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.persistence.domain.User;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long>
{
	// FIND BY NAME
	@Query("SELECT u from User u where u.firstName =?1 and u.surname =?2")
	User findUserByName(String firstName, String surname);
	
	//FIND BY ID
	@Query("SELECT u from User u where u.id =?1")
	List<User> findUserById(Long id);
	
	//FIND BY EMAIL
	@Query("SELECT u from User u where u.email =?1")
	User findUserByEmail(String email);
	
	//FIND EXISTING EMAIL
	@Query("SELECT count(u) = 1 from User u where u.email =?1")
	public boolean findExistingEmail(String email);
	
	//LOGIN DETAILS CHECK
	@Query("SELECT u from User u where u.username =?1 and u.password =?2")
	List<User> login(String username, String password);
}
