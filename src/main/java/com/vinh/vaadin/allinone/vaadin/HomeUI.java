package com.vinh.vaadin.allinone.vaadin;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.teemu.ratingstars.RatingStars;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vinh.vaadin.allinone.repo.StudentRepo;

@SpringUI
public class HomeUI extends UI {

	VerticalLayout root;
	@Autowired
	Content content;
	@Autowired
	StudentRepo repo;
	
	@Override
	protected void init(VaadinRequest request) {
		setRootLayout();
	}

	private void setRootLayout() {
		root = new VerticalLayout();

		root.addComponent(content);
		
		/*****************************/
		/*****************************/
		setContent(root);
	}
}
