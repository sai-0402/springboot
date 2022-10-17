package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ItemDao;
import com.model.Item;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
@RestController
public class ItemRestController {
   @Autowired
   ItemDao itemDao;
    
	@GetMapping("/homeinfo")
	@ApiOperation(value="get message",notes="api message displayed",nickname="checking")
	@ApiResponses(value= {@ApiResponse(code=200,message="Displayed"),@ApiResponse(code = 404, message = "Service not found")})
	public String gethomeinfo()
	{
		return "Home";
	}
	@PostMapping("/additem")
	@ApiOperation(value="Adding items",notes="api message displayed",nickname="checking")
	@ApiResponses(value= {@ApiResponse(code=200,message="Displayed"),@ApiResponse(code = 404, message = "Service not found")})
	public ResponseEntity addItem(@RequestBody Item item)
	{
		itemDao.save(item);
		return new ResponseEntity("item added",HttpStatus.OK);
	}
	@GetMapping("/getallitems")
	@ApiOperation(value="getting all the items",notes="api message displayed",nickname="checking")
	@ApiResponses(value= {@ApiResponse(code=200,message="Displayed"),@ApiResponse(code = 404, message = "Service not found")})
	public List<Item> getAllItems()
	{
		return itemDao.findAll();
	}
	@PatchMapping("/updateitem")
	public ResponseEntity updateItem(@RequestBody Item item)
	{
		itemDao.save(item);
		return new ResponseEntity("entity updated",HttpStatus.OK);
	}
	@DeleteMapping("/deleteitem")
	public ResponseEntity deleteitem(@RequestBody Item item)
	{
		itemDao.delete(item);
		return new ResponseEntity("item deleted",HttpStatus.OK);
		
	}
	@GetMapping("findbyid/{id}")
	public Item getItem(@PathVariable int id)
	{
		Item item=itemDao.findById(id).get();
		return item;
	}
	
}
