package com.rent.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.python.antlr.PythonParser.list_for_return;
import org.springframework.stereotype.Repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rent.model.QUser;
import com.rent.model.User;
import com.rent.sprite.UserTable;

@Repository
public class UserDaoImpl implements UserDao {

	@Resource
	private EntityManagerFactory emf;
	JPAQueryFactory query;
	private static final Logger logger = Logger.getLogger(RegisterDaoImpl.class);

	@Override
	public User getUser(Integer id) {
		EntityManager em = emf.createEntityManager();
		JPAQueryFactory query = new JPAQueryFactory(em);

		QUser quser = QUser.user;
		User user = null;

		try {
			user = query.selectFrom(quser).where(quser.id.eq(id)).fetchOne();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		return user;
	}

	@Override
	public Boolean addUser(User user) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(user);
			em.getTransaction().commit();
			logger.info("User added");
			return true;
		} catch (Exception e) {
			logger.error("error to insert User. " + e.getMessage());
		} finally {
			em.close();
		}

		return false;
	}

	@Override
	public User getExistingUser(String email) {
		EntityManager em = emf.createEntityManager();
		JPAQueryFactory query = new JPAQueryFactory(em);

		QUser quser = QUser.user;
		User user =null;
		
		try {
			 user = query.selectFrom(quser).where(quser.email.eq(email)).fetchOne();

		}catch(Exception e){
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return user;
	}

	@Override
	public int getExistingUserId(String email) {
		EntityManager em = emf.createEntityManager();
		JPAQueryFactory query = new JPAQueryFactory(em);

		QUser quser = QUser.user;
		int user = 0;
		
		try {
			user = query.select(quser.id).from(quser).where(quser.email.eq(email)).fetchOne();

		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			em.close();
		}
		 
		return user;
	}

	@Override
	public UUID getRegisterId(Integer user_id) {
		EntityManager em = emf.createEntityManager();
		JPAQueryFactory query = new JPAQueryFactory(em);

		QUser quser = QUser.user;
		UUID regId = null;
		
		try {
			regId = query.select(quser.regId.id).from(quser).where(quser.id.eq(user_id)).fetchOne();

		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			em.close();
		}
		
		return regId;
	}

	@Override
	public String District(Integer user_id) {
		EntityManager em = emf.createEntityManager();
		JPAQueryFactory query = new JPAQueryFactory(em);

		QUser quser = QUser.user;
		
		String district = null;
		
		try {
			district = query.select(quser.regId.district).from(quser).where(quser.id.eq(user_id)).fetchOne();

		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			em.close();
		}
		
		return district;
	}

	@Override
	public List<UserTable> getAllUser() {
		EntityManager em = emf.createEntityManager();
		JPAQueryFactory query = new JPAQueryFactory(em);

		List<UserTable> users = new ArrayList<>();
		QUser quser = QUser.user;
		
		List<Tuple> user = null;
		
		try
		{
			user = query.select(quser.id, quser.email, quser.password).from(quser).fetch();

			for (Tuple u : user) {
				UserTable uu = new UserTable();
				uu.setId(u.get(quser.id));
				uu.setEmail(u.get(quser.email));
				uu.setPassword(u.get(quser.password));

				users.add(uu);
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			em.close();
		}
		
		return users;
	}

	@Override
	public Boolean deleteUser(Integer user_id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			User user = em.find(User.class, user_id);
			if (user != null) {
				em.remove(user);
				em.getTransaction().commit();
				logger.info("User deleted");
				return true;
			} else {
				logger.error("User not found");
				return false;
			}
		} catch (Exception e) {
			logger.error("Error to delete User. " + e.getMessage());
		} finally {
			em.close();
		}
		return false;
	}
}
