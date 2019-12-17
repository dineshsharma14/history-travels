package org.launchcode.historytravels.models.data;

import org.launchcode.historytravels.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
// @Transactional, Spring is doing AOP behind the scenes like
// beginTransaction, commitTransaction etc.
public interface UserDao extends CrudRepository<User, Integer> {
}
