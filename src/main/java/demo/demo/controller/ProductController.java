package demo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.demo.constants.AppConstants;
import demo.demo.request.FlowerRequest;
import demo.demo.response.FlowerResponse;
import demo.demo.response.MessageResponse;
import demo.demo.response.PagedResponse;
import demo.demo.service.FlowerService;

@RestController
@RequestMapping(value = "/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	private FlowerService flowerService;

	@PutMapping(path = "/hello")
	public ResponseEntity<MessageResponse> hello() {
		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setMessage("asdasdhuahyuasghd");

		return ResponseEntity.status(HttpStatus.OK).body(messageResponse);
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<MessageResponse> createFlower(@ModelAttribute FlowerRequest flowerRequest) {

		return flowerService.createFlower(flowerRequest);
	}
	
	@GetMapping
	public PagedResponse<FlowerResponse> getAllMemo(
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
		return flowerService.findAll(page, size);
	}
}
