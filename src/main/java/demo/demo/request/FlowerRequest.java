package demo.demo.request;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class FlowerRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private double price;
	private MultipartFile files;
	private int quantity;

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

	public FlowerRequest() {
	}

	public FlowerRequest(String name, String description, double price, MultipartFile files, int quantity) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.files = files;
		this.quantity = quantity;
	}

	public MultipartFile getFiles() {
		return files;
	}

	public void setFiles(MultipartFile files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "FlowerRequest [name=" + name + ", description=" + description + ", price=" + price + ", files=" + files
				+ ", quantity=" + quantity + "]";
	}

}
