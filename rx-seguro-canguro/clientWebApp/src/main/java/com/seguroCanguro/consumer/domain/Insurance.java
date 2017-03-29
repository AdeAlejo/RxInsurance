package com.seguroCanguro.consumer.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Insurance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String id;
	private String name;
	private Double price;
	private String description;
        
        private List<InsuranceCategory> categories;
	
	
	public Insurance() {
	}
	
	public Insurance(String id, String name, Double price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
                categories = new ArrayList<>();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
        public List<InsuranceCategory> getCategories() {
            return categories;
        }

        public void setCategories(List<InsuranceCategory> categories) {
            this.categories = categories;
        }


	@Override
	public String toString() {
		return "Insurance {id='" + id + "', name='" + name + "', price='" + price
				+ "', description='" + description + "'}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Insurance other = (Insurance) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
	
	
	
}
