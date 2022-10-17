package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.model.Item;
@Repository
public interface ItemDao extends JpaRepository<Item,Integer> {

//	Item findByprice(float price);
//
//	Item findByName(String itemName);
	
}
