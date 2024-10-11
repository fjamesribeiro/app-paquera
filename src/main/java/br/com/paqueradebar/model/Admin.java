package br.com.paqueradebar.model;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "admin")
@Getter
@Setter
@PrimaryKeyJoinColumn(name="id")
@OnDelete(action = OnDeleteAction.CASCADE) 
public class Admin extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
}
