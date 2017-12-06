package com.TheNeptuneZ.SpringBoot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.TheNeptuneZ.SpringBoot.model.User;

/**
 * 
 * @author TheNeptuneZ
 *
 * TheNeptuneZ.github.io
 */
public interface UserRepo extends JpaRepository<User, Long> {

	List<User> findByLastName(String lastName);

}
