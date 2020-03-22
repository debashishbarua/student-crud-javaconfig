package com.cognizant.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setjdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	@Transactional
	public String create(Student customer) {
		String query = "insert into student values(?,?,?,?)";
		int res = jdbcTemplate.update(query, new Object[] { customer.getId(), customer.getName(),
				customer.getEmail(), customer.getPhoneNo() });

		if (res > 0) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	public List<Student> findAll() {
		String query = "select * from student";
		return jdbcTemplate.query(query,
				(rs, rowNum) -> new Student(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4)));

	}

	@Override
	public List<Student> findByName(String name) {
		String query = "select * from student  where cust_name=?";
		return jdbcTemplate.query(query, new Object[] { name },
				(rs, rowNum) -> new Student(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4)));

	}

}
