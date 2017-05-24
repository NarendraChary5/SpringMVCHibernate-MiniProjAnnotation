package dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import bo.StudentBO;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {
	
	@Resource(name="sessionFactory")
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
           this.sessionFactory = sessionFactory;
    }
   
    protected Session getSession(){
           return sessionFactory.openSession();
    }
    
	@Override
	public List<StudentBO> getAllStudent() {
		List<StudentBO> listBO = null;
		Query query = null;
		Session sesion = null;
		sesion = sessionFactory.openSession();
		query = sesion.getNamedQuery("GET_ALL_STUDENTS");
		listBO = query.list();
		return listBO;
	}
	

	@Override
	public int insertStudent(StudentBO bo) {
		int Insertcount=0;
		Session sesion = null;
		Transaction tx = null;
		sesion = sessionFactory.openSession();
		try{
			tx = sesion.beginTransaction();
			Insertcount = (int) sesion.save(bo);
			tx.commit();
		}
		catch(Exception e){
			tx.rollback();
		}
		sesion.close();
		return Insertcount;
	}

	@Override
	public StudentBO getStudentByNo(int sno) {
		StudentBO bo = null;
		Transaction tx = null;
		Session sesion = null;
		sesion = sessionFactory.openSession();
		tx = sesion.beginTransaction();
		bo = (StudentBO) sesion.get(StudentBO.class, new Integer(sno));
		return bo;
	}
	

	@Override
	public int updateStudent(StudentBO bo) {
		int count = 0;
		Transaction tx = null;
		Session sesion = null;
		sesion = sessionFactory.openSession();
		try{
			tx = sesion.beginTransaction();
			sesion.update(bo);
			count = count+1;
			tx.commit();
		}
		catch(Exception e){
			tx.rollback();
		}
		sesion.close();
		return count;
	}

	@Override
	public int deleteStudent(int sno) {
		int count = 0;
		StudentBO bo = null;
		Transaction tx = null;
		Session sesion = null;
		sesion = sessionFactory.openSession();
		try{
			tx = sesion.beginTransaction();
			bo = (StudentBO) sesion.get(StudentBO.class, new Integer(sno));
			sesion.delete(bo);
			count = count+1;
			tx.commit();
		}
		catch(Exception e){
			tx.rollback();
		}
		sesion.close();
		return count;
	}
}