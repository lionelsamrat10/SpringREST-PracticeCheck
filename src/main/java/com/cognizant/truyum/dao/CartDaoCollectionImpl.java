package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.exception.GlobalExceptionHandler;
import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Component
public class CartDaoCollectionImpl implements CartDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	private static HashMap<String, Cart> userCarts;

	public CartDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<String, Cart>();
		}
	}

	@Override
	public void addCartItem(String userId, long menuItemId) {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);

		if (userCarts.containsKey(userId)) {
			List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
			menuItemList.add(menuItem);
		} else {
			Cart cart = new Cart(new ArrayList<MenuItem>(), 0.0);
			cart.getMenuItemList().add(menuItem);
			userCarts.put(userId, cart);
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(String userId) throws GlobalExceptionHandler {
		if (userCarts.containsKey(userId)) {
			List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
			if (menuItemList.isEmpty()) {
				throw (new GlobalExceptionHandler("Empty"));
			} else {
				double total = 0.0;
				for (int i = 0; i < menuItemList.size(); i++) {
					total += menuItemList.get(i).getPrice();
				}
				userCarts.get(userId).setTotal(total);
			}
			LOGGER.debug("MenuItemList: {}",menuItemList);
			return menuItemList;
		} else {
			throw (new GlobalExceptionHandler("Wrong user"));
		}

	}

	@Override
	public void deleteCartItem(String userId, long menuItemId) {
		List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				menuItemList.remove(i);
				break;
			}
		}
	}

}