package br.com.paqueradebar.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@NotBlank(message = "O email é obrigatório")
	@Email(message = "Formato de email inválido")
	@Column(name = "email", nullable = false)
	private String email;

	@NotBlank(message = "O whatsapp é obrigatório")
	@Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}", message = "Formato de whatsapp inválido. O formato correto é (XX) XXXXX-XXXX")
	@Column(name = "whatsapp", nullable = false)
	private String whatsapp;

	@Column(name = "dtnascimento")
	@DateTimeFormat(pattern = "dd/MM/YYYY")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtnascimento;

	@Column(name = "sexo")
	@Pattern(regexp = "(?i)^[mfno]$", message = "O sexo deve ser M, F, O ou N")
	private String sexo;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "estado")
	@Pattern(regexp = "^[a-zA-Z]{2}$", message = "O estado deve conter exatamente duas letras")
	private String estado;
}
