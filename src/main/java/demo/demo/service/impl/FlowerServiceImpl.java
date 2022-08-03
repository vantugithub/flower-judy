package demo.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import demo.demo.entity.Flowers;
import demo.demo.repository.FlowerRepository;
import demo.demo.request.FlowerRequest;
import demo.demo.response.FlowerResponse;
import demo.demo.response.MessageResponse;
import demo.demo.response.PagedResponse;
import demo.demo.service.FlowerService;

@Service
public class FlowerServiceImpl implements FlowerService {

	@Autowired
	private FilesService filesService;

	@Autowired
	private FlowerRepository flowerRepository;

	@Override
	public ResponseEntity<MessageResponse> createFlower(FlowerRequest flowerRequest) {

		Flowers flower = new Flowers();
		flower.setDesription(flowerRequest.getDescription());
		flower.setName(flowerRequest.getName());
		flower.setPrice(flowerRequest.getPrice());
		flower.setQuantity(flowerRequest.getQuantity());

		String urlImage = filesService.save(flowerRequest.getFiles());
		flower.setUrl(urlImage);

		flowerRepository.save(flower);

		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setMessage("Save success");
		messageResponse.setStatus(HttpStatus.OK.value());

		return ResponseEntity.status(HttpStatus.OK).body(messageResponse);
	}

	@Override
	public PagedResponse<FlowerResponse> findAll(int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Direction.DESC, "Id");
		Page<Flowers> flowers = flowerRepository.findAll(pageable);

		List<FlowerResponse> postResponses = new ArrayList<>(flowers.getContent().size());

		for (Flowers flower : flowers) {
			postResponses.add(new FlowerResponse(flower.getId(), flower.getName(), flower.getDesription(),
					flower.getPrice(), flower.getUrl(), flower.getQuantity()));
		}

		return new PagedResponse<>(postResponses, flowers.getNumber(), flowers.getSize(), flowers.getTotalElements(),
				flowers.getTotalPages(), flowers.isLast());
	}

}
