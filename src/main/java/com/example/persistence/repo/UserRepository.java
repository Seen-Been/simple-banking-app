package com.example.persistence.repo;

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
	@Query("select u from User u where u.firstName =?1 and u.surname =?2")
	List<User> findUserByName(String firstName, String surname);
	
	//FIND BY ID
	@Query("select u from User u where u.id =?1")
	List<User> findUserById(long id);
	
	//LOGIN DETAILS CHECK
	@Query("select u from User u where u.username =?1 and u.password =?2")
	List<User> login(String username, String password);
}
