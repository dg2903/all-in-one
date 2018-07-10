package com.vinh.vaadin.allinone.vaadin;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vinh.vaadin.allinone.entity.Student;
import com.vinh.vaadin.allinone.repo.StudentRepo;

@SpringComponent
public class Form extends FormLayout{
	@Autowired
	StudentRepo repo;
	
	TextField firstName = new TextField("First Name");
	TextField lastName = new TextField("Last Name");
	TextField email = new TextField("Email");
	Button save = new Button("Save");
	Button delete = new Button("Delete");
	
	BeanValidationBinder<Student> binder = new BeanValidationBinder<>(Student.class);
	
	public Form(Content content) {
		setCaption("Student Information");
		
		setSizeUndefined();
		
		addComponents(firstName, lastName, email, save, delete);
		binder.bindInstanceFields(this);
		
		save.addClickListener(event -> {
			if(binder.getBean() != null) {
				content.save(binder.getBean());
			} else if (binder.isValid()) {
				System.out.println("Binder was NULL, Creating new student: " + firstName.getValue() 
																				+ lastName.getValue() 
																				+ email.getValue());
				content.save(new Student(firstName.getValue(), lastName.getValue(),email.getValue()));
			}
			binder.setBean(null);
		});
		
		delete.addClickListener(event -> {
			if(binder.getBean() != null) {
				content.delete(binder.getBean());
				System.out.println(binder.getBean() == null ? "It is NULL" : binder.getBean());
			}
			binder.setBean(null);
		});
		
		save.setClickShortcut(KeyCode.ENTER, null);
		
	}
	
	public void getSelectedStudentDetail(Student student) {
		binder.setBean(student);
		System.out.println(student);
	}
}
