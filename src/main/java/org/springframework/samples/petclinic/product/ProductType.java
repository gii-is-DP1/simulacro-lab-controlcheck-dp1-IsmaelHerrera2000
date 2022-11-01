package org.springframework.samples.petclinic.product;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProductType extends BaseEntity{
	@Id
    Integer id;
	@NotNull
	@Column(unique=true)
	@Size(min=3,max=50)
    String name;
}
