package test;


import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import utils.HibernateUtils;

import javax.persistence.criteria.CriteriaBuilder;

public class HibernateDemo2 {
    @Test
    public void TestAdd() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Instructor instructor = new Instructor();
            instructor.setFirstName("Shu");
            instructor.setFirstName("Yang");
            instructor.setEmail("Yang@itlize.com");

            Course course = new Course();
            course.setName("Spring");

            instructor.getCourses().add(course);
            course.setInstructor(instructor);

            session.save(instructor);


            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Test
    public void TestDelete() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Instructor instructor = (Instructor) session.get(Instructor.class, 2);
            session.delete(instructor);

            tx.commit();
        }catch (Exception e) {

        }finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Test
    public void TestUpdate() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Instructor instructor = (Instructor) session.get(Instructor.class, 1);
            Course course = (Course) session.get(Course.class, 1);
            instructor.getCourses().add(course);
            course.setInstructor(instructor);

            tx.commit();
        }catch (Exception e) {

        }finally {
            session.close();
            sessionFactory.close();
        }
    }


//    @Test
//    public void TestAddOneToOne() {
//        SessionFactory sessionFactory = null;
//        Session session = null;
//        Transaction tx = null;
//        try {
//            sessionFactory = HibernateUtils.getSessionFactory();
//            session = sessionFactory.openSession();
//            tx = session.beginTransaction();
//
//            Instructor instructor = new Instructor();
//            instructor.setFirstName("Stephen");
//            instructor.setFirstName("Li");
//            instructor.setEmail("Stephen@itlize.com");
//
//            InstructorDetail instructorDetail = new InstructorDetail();
//            instructorDetail.setHobby("Basketball");
//
//            session.save(instructor);
//            session.save(instructorDetail);
//
//            tx.commit();
//
//
//
//        }catch (Exception e) {
//            tx.rollback();
//        }
//    }

}
