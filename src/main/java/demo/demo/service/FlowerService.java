package demo.demo.service;

import org.springframework.http.ResponseEntity;

import demo.demo.request.FlowerRequest;
import demo.demo.response.FlowerResponse;
import demo.demo.response.MessageResponse;
import demo.demo.response.PagedResponse;

public interface FlowerService {
	ResponseEntity<MessageResponse> createFlower(FlowerRequest flowerRequest);
	
	public PagedResponse<FlowerResponse> findAll(int page,int size);
} 
