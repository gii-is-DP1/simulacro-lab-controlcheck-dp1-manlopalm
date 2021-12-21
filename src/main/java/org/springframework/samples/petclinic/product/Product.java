package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseEntity {
	
	@NotNull
	@Size(min = 3, max = 50)
    private String name;
	
	@NotNull
	@PositiveOrZero
    private double price;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "product_type_id")
    ProductType productType;
}
