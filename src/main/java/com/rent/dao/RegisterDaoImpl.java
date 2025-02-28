package com.rent.dao;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.stereotype.Repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rent.model.QRegister;
import com.rent.model.Register;
import com.rent.sprite.RegisterTable;

@Repository
public class RegisterDaoImpl implements RegisterDao {

	@Resource
	private EntityManagerFactory emf;
	JPAQueryFactory query;
	private static final Logger logger = Logger.getLogger(RegisterDaoImpl.class);

	@Override
	public Boolean setRegisterDetail(Register register) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(register);
			em.getTransaction().commit();
			logger.info("User details added");
			return true;
		} catch (Exception e) {
			logger.error("error to insert User Details " + e.getMessage());
		} finally {
			em.close();
		}

		return false;
	}

	@Override
	public String getEmail(String email) {
		EntityManager em = emf.createEntityManager();
		this.query = new JPAQueryFactory(em);
		QRegister qRegister = QRegister.register;
		logger.info("email: " + email);
		String ee = null;

		try {
			ee = query.select(qRegister.email).from(qRegister).where(qRegister.email.eq(email)).fetchOne();
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally
		{
			em.close();
		}

		return ee;
	}

	@Override
	public String getPassword(String password) {
		EntityManager em = emf.createEntityManager();
		this.query = new JPAQueryFactory(em);
		QRegister qRegister = QRegister.register;
		String p = null;

		try {
			p = query.select(qRegister.password).from(qRegister).where(qRegister.password.eq(password)).fetchOne();
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			em.close();
			
		}

		return p;
	}

	@Override
	public Register getRegisterId(UUID regId) {
		EntityManager em = emf.createEntityManager();
		this.query = new JPAQueryFactory(em);
		QRegister qRegister = QRegister.register;
		logger.info("regId: " + regId);
		Register e = null;

		try {
			e = query.select(qRegister).from(qRegister).where(qRegister.id.eq(regId)).fetchFirst();
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			em.close();
		}

		return e;
	}

	@Override
	public UUID getIdByEmail(String email) {
		EntityManager em = emf.createEntityManager();
		this.query = new JPAQueryFactory(em);
		QRegister qRegister = QRegister.register;
		UUID e = null;

		try {
			e = query.select(qRegister.id).from(qRegister).where(qRegister.email.eq(email)).fetchOne();
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			em.close();
		}

		return e;
	}

	@Override
	public List<RegisterTable> getRegisterDetail(UUID regId) {
		EntityManager em = emf.createEntityManager();
		this.query = new JPAQueryFactory(em);
		QRegister qRegister = QRegister.register;
		List<Tuple> e = null;

		List<RegisterTable> registerTable = new ArrayList<RegisterTable>();

		try {
			e = query
					.select(qRegister.id, qRegister.fullname, qRegister.email, qRegister.mobileno, 
							qRegister.occupation, qRegister.gender, qRegister.addressType, 
							qRegister.province, qRegister.district, qRegister.city)
					.from(qRegister).where(qRegister.id.eq(regId)).fetch();

			for (Tuple t : e) {
				RegisterTable rr = new RegisterTable();
				rr.setFullname(t.get(qRegister.fullname));
				rr.setEmail(t.get(qRegister.email));
				rr.setMobileno(t.get(qRegister.mobileno));
				rr.setOccupation(t.get(qRegister.occupation));
				rr.setGender(t.get(qRegister.gender));
				rr.setAddressType(t.get(qRegister.addressType));
				rr.setProvince(t.get(qRegister.province));
				rr.setDistrict(t.get(qRegister.district));
				rr.setCity(t.get(qRegister.city));
				
				registerTable.add(rr);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			em.close();
		}

		return registerTable;
	}

	@Override
	public Boolean deteleUserReg(UUID regId) {
		 EntityManager em = emf.createEntityManager();
		    em.getTransaction().begin();
		    try {	   
		        Register user = em.find(Register.class, regId);
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
