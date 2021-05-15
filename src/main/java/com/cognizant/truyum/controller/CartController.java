package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.exception.GlobalExceptionHandler;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	@Autowired
	CartService cartService;

	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable("userId") String userId, @PathVariable("menuItemId") long menuItemId) {
		LOGGER.info("Start : Inside addCartItem");
		cartService.addCartItem(userId, menuItemId);
		LOGGER.info("End: addCartItem");
	}

	@GetMapping("/{userId}")
	public List<MenuItem> getAllCartItems(@PathVariable("userId") String userId) throws GlobalExceptionHandler {
		LOGGER.info("Start: Inside getAllcartItems");
		LOGGER.info("End : getAllCartItems");
		return cartService.getAllCartItems(userId);
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItem(@PathVariable("userId") String userId,@PathVariable("menuItemId") long menuItemId)
	{
		LOGGER.info("Start: Inside deleteCartItem");
		cartService.deleteCartItem(userId, menuItemId);
		LOGGER.info("End: deleteCartItem");
	}
}
