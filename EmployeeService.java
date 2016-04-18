package mx.uatx;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class EmployeeService {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void register(EmployeeDTO emp){
		
		// Acquire session
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// Save employee, saving behavior get done in a transactional manner
		session.persist(convert(emp));
		session.getTransaction().commit();
	}
	
	private Employee convert(EmployeeDTO emp){
		Employee e=new Employee();		
		e.setEmployeeId(emp.getEmployeeId());
		e.setUsuario(emp.getUsuario());
		e.setPass(emp.getPass());		
		return e;
	}
}