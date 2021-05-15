package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	@Autowired
	MenuItemService menuItemService;
	
	@GetMapping
	public List<MenuItem> getAllMenuItems(){
		LOGGER.info("Start: Inside getAllMenuItems");
		LOGGER.info("End:  getAllMenuItems");
		return menuItemService.getMenuItemListCustomer();
	}
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable("id") long id) {
		LOGGER.info("Start: Inside getMenuItem");
		LOGGER.info("End:  getMenuItem");
		return menuItemService.getMenuItem(id);
	}
	@PutMapping("/{id}")
	public void modifyMenuItem(@RequestBody MenuItem menuItem)
	{
		LOGGER.info("Start: Inside modifyMenuItem");
		menuItemService.modifyMenuItem(menuItem);
		LOGGER.info("End:  modifyMenuItem");
	}
}
