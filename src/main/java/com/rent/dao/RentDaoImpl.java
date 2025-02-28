package com.rent.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rent.model.QBooking;
import com.rent.model.QRent;
import com.rent.model.QUser;
import com.rent.model.Rent;
import com.rent.model.Status;
import com.rent.model.User;
import com.rent.sprite.AdminBookingTable;
import com.rent.sprite.DescriptionResult;
import com.rent.sprite.RentList;
import com.rent.sprite.RentTable;

@Repository
public class RentDaoImpl implements RentDao {

	@Resource
	private EntityManagerFactory emf;
	JPAQueryFactory query;
	private static final Logger logger = Logger.getLogger(RegisterDaoImpl.class);

	@Override
	public Boolean addUpload(Rent rent) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(rent);
			em.getTransaction().commit();
			logger.info("Rent details added");
			return true;
		} catch (Exception e) {
			logger.error("error to insert rent Details " + e.getMessage());
		} finally {
			em.close();
		}
		return false;
	}

	@Override
	public Rent getRentId(UUID rent_id) {
		EntityManager em = emf.createEntityManager();
		JPAQueryFactory query = new JPAQueryFactory(em);

		QRent qRent = QRent.rent;
		Rent rent = null;

		try {
			rent = query.selectFrom(qRent).where(qRent.id.eq(rent_id)).fetchOne();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		return rent;
	}

	@Override
	public String getRentType(UUID rent_id) {
		EntityManager em = emf.createEntityManager();
		JPAQueryFactory query = new JPAQueryFactory(em);

		QRent qRent = QRent.rent;
		String rent = null;
		try {
			rent = query.select(qRent.rentType).from(qRent).where(qRent.id.eq(rent_id)).fetchFirst();

			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		return rent;
	}

	@Override
	public Boolean updateRent(Rent rent) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(rent);
			em.getTransaction().commit();
			logger.info("Rent details added");
			return true;
		} catch (Exception e) {
			logger.error("failed to update rent Details " + e.getMessage());
		} finally {
			em.close();
		}
		return false;
	}

	@Override
	public Boolean changestatus(UUID rentId, Status status) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			// Assuming Rent is the entity class and it has a field named status
			Rent rent = em.find(Rent.class, rentId);
			if (rent != null) {
				rent.setStatus(status); // Assuming setStatus is a method in Rent entity to set the status
				em.merge(rent);
				em.getTransaction().commit();
				logger.info("Rent details updated");
				return true;
			} else {
				logger.error("Rent not found for ID: " + rentId);
				return false;
			}
		} catch (Exception e) {
			logger.error("Failed to update rent details: " + e.getMessage());
			return false;
		} finally {
			em.close();
		}
	}

	@Override
	public List<RentList> getAllRent() {
		EntityManager em = emf.createEntityManager();
		JPAQueryFactory query = new JPAQueryFactory(em);

		QRent qRent = QRent.rent;

		List<RentList> rents = new ArrayList<>();

		try {
			List<Tuple> rent = query
					.select(qRent.title, qRent.id, qRent.location, qRent.price, qRent.status, qRent.createdAt,
							qRent.description, qRent.rentType, qRent.createdBy.email, qRent.PropertySpecification)
					.from(qRent).fetch();

			for (Tuple b : rent) {
				RentList bb = new RentList();
				bb.setTitle(b.get(qRent.title));
				bb.setLocation(b.get(qRent.location));
				bb.setPrice(b.get(qRent.price));
				bb.setStatus(b.get(qRent.status));
				bb.setCreated_at(b.get(qRent.createdAt));
				bb.setDescription(b.get(qRent.description));
				bb.setRentType(b.get(qRent.rentType));
				bb.setCreatedBy(b.get(qRent.createdBy.email));
				bb.setRent_id(b.get(qRent.id));
				bb.setPropertySpecification(b.get(qRent.PropertySpecification));

				rents.add(bb);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		return rents;

	}

	@Override
	public Boolean deleteRent(UUID rent_id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			Rent rent = em.find(Rent.class, rent_id);
			if (rent != null) {
				em.remove(rent);
				em.getTransaction().commit();
				logger.info("Rent deleted");
				return true;
			} else {
				logger.error("Rent not found");
				return false;
			}
		} catch (Exception e) {
			logger.error("Error to delete Rent. " + e.getMessage());
		} finally {
			em.close();
		}
		return false;
	}

	@Override
	public List<String> getDescription() {
		EntityManager em = emf.createEntityManager();
		JPAQueryFactory query = new JPAQueryFactory(em);

		QRent qRent = QRent.rent;

		List<String> descriptions = Collections.emptyList();

		try {
			descriptions = query.select(qRent.description).from(qRent).fetch();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return descriptions;
	}
}
