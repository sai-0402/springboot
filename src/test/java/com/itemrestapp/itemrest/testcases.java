package com.itemrestapp.itemrest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.dao.ItemDao;
import com.model.Item;
@SpringBootTest
public class testcases {
	@Autowired
	   ItemDao itemDao;
   @Test 
   void test() {
   Item item = new Item();
   item.setItemId(1);
   item.setItemName("ram");
   item.setPrice(100);
   item.setQuant(10);
   itemDao.save(item);
   Item item1=itemDao.findById(item.getItemId()).get();
   Assertions.assertEquals(item.getItemName(),item1.getItemName()); 
}
   
   
   
   
//   @Test
//   void checkByPrice()
//   {
//	  Item item= new Item();
//	  item.setItemName("coffee");
//	  item.setPrice(10);
//	  item.setQuant(10);
//	  itemDao.save(item);
//	  Item item1 =itemDao.findByprice(10);
//	  Assertions.assertEquals(item1.getItemName(),"coffee");
//	  
//   }
//   @Test
//   void checkByName()
//   {
//	   Item item = new Item();
//	   item.setItemName("rice");
//	   item.setPrice(10);
//	   item.setQuant(10);
//	   itemDao.save(item);
//	   Item item1=itemDao.findByName("rice");
//	   Assertions.assertEquals(item1.getItemName(),"rice");
//	   
   //}
//   @Test
//   public void Insertion() throws URISyntaxException 
//   {
//       RestTemplate restTemplate = new RestTemplate();
//        final String baseUrl = "http://localhost:9091/additem";
//       URI uri = new URI(baseUrl);
//    
//       ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
//       Assertions.assertEquals(HttpStatus.OK,result.getStatusCode());
//   }
//   @Test 
//   public void Deletion() throws URISyntaxException
//   {   Item item =new Item(1,"Coffee",200f,20);
//       itemDao.save(item);
//	   RestTemplate restTemplate = new RestTemplate();
//	   final String url = "http://localhost:9091/deleteitem";
//	   URI uri =new URI(url);
//	   ResponseEntity<String> result = restTemplate.getForEntity(uri,String.class);
//	   System.out.println(result.getBody());
//	   assertEquals(200,result.getStatusCodeValue());
//	   assertEquals(true,((item)(result.getBody().get(0))));
//	  
//   }
//   
   @Test 
   public void getallitems() throws URISyntaxException
   {   Item item =new Item(1,"Coffee",200f,20);
       itemDao.save(item);
	   RestTemplate restTemplate = new RestTemplate();
	   final String url = "http://localhost:9091/getallitems";
	   URI uri =new URI(url);
	   ResponseEntity<List> result = restTemplate.getForEntity(uri,List.class);
	   System.out.println(result.getBody());
	   assertEquals(200,result.getStatusCodeValue());
	   assertEquals(true,((Item)(result.getBody().get(0))).getItemName());
	  
   }
   
   
   
}