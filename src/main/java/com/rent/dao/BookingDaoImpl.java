package com.rent.dao;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rent.model.Booking;
import com.rent.model.QBooking;
import com.rent.model.QRent;
import com.rent.model.QUser;
import com.rent.model.Rent;
import com.rent.model.Status;
import com.rent.sprite.AdminBookingTable;
import com.rent.sprite.BookingTable;
import com.rent.sprite.RentList;

@Repository
public class BookingDaoImpl implements BookingDao {

	@Resource
	private EntityManagerFactory emf;
	JPAQueryFactory query;
	private static final Logger logger = Logger.getLogger(RegisterDaoImpl.class);

	@Override
	public Boolean setBookingDetails(Booking booking) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(booking);
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
	public List<RentList> getRentDetailsByBooking(Integer user_id) {
		EntityManager em = emf.createEntityManager();
		this.query = new JPAQueryFactory(em);
		QRent qRent = QRent.rent;
		QBooking qBooking = QBooking.booking;
		// QUser qUser = QUser.user;

		List<RentList> rentlist = new ArrayList<RentList>();

		try {
			List<Tuple> r = query
					.select(qRent.id, qRent.createdAt, qRent.title, qRent.price, qRent.PropertySpecification,
							qRent.imagePath, qRent.imageName, qRent.rentType, qRent.location, qRent.description,
							qRent.status)
					.from(qRent).leftJoin(qBooking).on(qBooking.rent.id.eq(qRent.id))
					.where(qBooking.user.id.eq(user_id)).fetch();

			for (Tuple r1 : r) {
				RentList rr = new RentList();
				rr.setPropertySpecification(r1.get(qRent.PropertySpecification));
				rr.setTitle(r1.get(qRent.title));
				rr.setPrice(r1.get(qRent.price));
				rr.setCreated_at(r1.get(qRent.createdAt));
				rr.setRentType(r1.get(qRent.rentType));
				rr.setLocation(r1.get(qRent.location));
				rr.setRent_id(r1.get(qRent.id));
				rr.setDescription(r1.get(qRent.description));
				rr.setStatus(r1.get(qRent.status));

				// converting image byte[] datatype into base64 String
				String base64image = Base64.getEncoder().encodeToString(r1.get(qRent.imagePath));
				rr.setImgpath(base64image);
				rr.setImgname(r1.get(qRent.imageName));

				rentlist.add(rr);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}

		return rentlist;
	}

	@Override
	public List<AdminBookingTable> getAllBookingsBooked() {
		EntityManager em = emf.createEntityManager();
		JPAQueryFactory query = new JPAQueryFactory(em);

		QBooking qBooking = QBooking.booking;
		QRent qRent = QRent.rent;

		List<AdminBookingTable> bookings = new ArrayList<>();

		try {
			List<Tuple> booking = query
					.select(qBooking.id, qBooking.name, qBooking.email, qBooking.mobileno, qBooking.rentType,
							qBooking.comment, qBooking.createdAt, qRent.title, qRent.id, qBooking.rent.id,
							qRent.location, qRent.price, qRent.status)
					.from(qBooking).leftJoin(qRent).on(qBooking.rent.id.eq(qRent.id)).fetch();

			for (Tuple b : booking) {
				AdminBookingTable bb = new AdminBookingTable();
				bb.setBookingId(b.get(qBooking.id));
				bb.setName(b.get(qBooking.name));
				bb.setEmail(b.get(qBooking.email));
				bb.setMobileno(b.get(qBooking.mobileno));
				bb.setRentType(b.get(qBooking.rentType));
				bb.setComment(b.get(qBooking.comment));
				bb.setCreatedAt(b.get(qBooking.createdAt));
				bb.setTitle(b.get(qRent.title));
				bb.setRentId(b.get(qBooking.rent.id));
				bb.setLocation(b.get(qRent.location));
				bb.setPrice(b.get(qRent.price));
				bb.setStatus(b.get(qRent.status));

				bookings.add(bb);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		return bookings;
	}

	@Override
	public Status getStatus(Integer user_id) {
		EntityManager em = emf.createEntityManager();
		this.query = new JPAQueryFactory(em);
		QRent qRent = QRent.rent;
		QBooking qBooking = QBooking.booking;
		// QUser qUser = QUser.user;

		Status status = null;

		try {
			status = query.select(qRent.status).from(qRent).leftJoin(qBooking).on(qBooking.rent.id.eq(qRent.id))
					.where(qBooking.user.id.eq(user_id)).fetchOne();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}

		return status;
	}

}
