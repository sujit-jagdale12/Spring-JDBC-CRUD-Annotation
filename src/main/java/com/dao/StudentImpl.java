package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.model.Student;

@Component("dao")
public class StudentImpl implements StudentDao {

	public JdbcTemplate template;

	@Override
	public int saveStudent(Student student) {

		String query = "insert into student(name,email,age,dept)value(?,?,?,?);";
		int update = this.template.update(query, student.getName(), student.getEmail(), student.getAge(),
				student.getDept());
		return update;
	}

	@Override
	public int updateStudent(Student student) {
		String query = "update student set name=?,email=?,age=?,dept=? where id=?;";
		int update = this.template.update(query, student.getName(), student.getEmail(), student.getAge(),
				student.getDept(), student.getId());
		return update;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		System.out.println("Injecting template in Dao");
		this.template = template;
	}

	@Override
	public int deleteStudent(int id) {
		String query = "delete from student where id=?;";
		int update = this.template.update(query, id);
		return update;
	}

	@Override
	public Student getStudent(int id) {
		String query = "select *from student where id=?";
		Student student = new Student();
		Student s = this.template.queryForObject(query, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setAge(rs.getInt(4));
				student.setDept(rs.getString(5));
				return student;
			}
		}, id);
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		String query = "select *from student";
		List<Student> list = this.template.query(query, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student=new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setAge(rs.getInt(4));
				student.setDept(rs.getString(5));
				return student;
			}
		});
		return list;
	}

}
