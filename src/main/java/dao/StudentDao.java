package dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import entities.Student;

public class StudentDao {

	private HibernateTemplate hbnTamplate;

	// Create
	@Transactional
	public int insertStudent(Student std) {
		Integer insert = (Integer) hbnTamplate.save(std);
		return insert;
	}

	// Read by Id
	public Student getById(int sId) {
		Student newStudent = this.hbnTamplate.get(Student.class, sId);
		return newStudent;

	}

	// Read All
	public List<Student> getAll() {
		List<Student> list = this.hbnTamplate.loadAll(Student.class);
		return list;
	}

	// Delete
	@Transactional
	public void deleteStudent(int id) {
		Student deleteById = this.hbnTamplate.get(Student.class, id);
		this.hbnTamplate.delete(deleteById);
	}

	// Update
	@Transactional
	public void updateStudent(Student std) {
		this.hbnTamplate.update(std);
	}

	public HibernateTemplate getHbnTamplate() {
		return hbnTamplate;
	}

	public void setHbnTamplate(HibernateTemplate hbnTamplate) {
		this.hbnTamplate = hbnTamplate;
	}

}
