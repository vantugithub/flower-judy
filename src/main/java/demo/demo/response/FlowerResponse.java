package demo.demo.response;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

public class FlowerResponse {
	private int id;
	private String name;
	private String description;
	private double price;
	private String url;
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public FlowerResponse() {
	}

	public FlowerResponse(int id, String name, String description, double price, String url, int quantity) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.setUrl(url);
		this.quantity = quantity;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
