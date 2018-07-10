package com.vinh.vaadin.allinone.vaadin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vinh.vaadin.allinone.entity.Student;
import com.vinh.vaadin.allinone.repo.StudentRepo;

@SpringComponent
public class Content extends HorizontalLayout {
	
	@Autowired
	private StudentRepo repo;
	List<Student> studentList = new ArrayList<>();
	Grid<Student> grid = new Grid<>(Student.class);
	
	Form form;
	
	@PostConstruct
	public void init() {
		updateGrid();
	}
	
	public Content() {
		form = new Form(this);
		grid.setColumns("firstName", "lastName", "email");
		grid.addItemClickListener(event -> {
			form.getSelectedStudentDetail(event.getItem());
		});
		
//		setSizeFull();
		addComponentsAndExpand(grid);
		addComponents(form);
	}
	
	private void updateGrid() {
		studentList = repo.findAll();
		grid.setItems(studentList);
	}
	
	public void updateStudent(Student student) {
		repo.save(student);
		grid.asSingleSelect().clear();
		updateGrid();
	}
	
	public void save(Student student) {
		repo.save(student);
		updateGrid();
	}
	
	public void findByLastName(String name) {
		System.out.println(repo.findByLastName(name));
	}

	public void delete(Student student) {
		repo.delete(student);
		updateGrid();
	}
}
