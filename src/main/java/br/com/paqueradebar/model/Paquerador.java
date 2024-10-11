package br.com.paqueradebar.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.paqueradebar.validation.Create;
import br.com.paqueradebar.validation.Update;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "paquerador")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id")
@OnDelete(action = OnDeleteAction.CASCADE)
public class Paquerador extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank(groups = Create.class, message = "O whatsapp é obrigatório")
	@Pattern(groups = { Create.class,
			Update.class }, regexp = "\\(\\d{2}\\)(9\\d{4}-\\d{4}|99999-9999)", message = "Formato de whatsapp inválido. O formato correto é (XX)XXXXX-XXXX, exceto quando for (XX)99999-9999")
	@Column(name = "whatsapp", nullable = false)
	private String whatsapp;

	@NotNull(groups = Create.class, message = "A data de nascimento é obrigatório")
	@Column(name = "dtnascimento", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/YYYY")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dtnascimento;

	@NotBlank(groups = Create.class, message = "O sexo é obrigatório")
	@Column(name = "sexo", nullable = false)
	@Pattern(groups = { Create.class, Update.class }, regexp = "^[mMfF]$", message = "O sexo deve ser 'M' ou 'F'")
	private String sexo;

	@NotBlank(groups = Create.class, message = "O interesse é obrigatório")
	@Column(name = "interesse", nullable = false)
	@Pattern(groups = { Create.class,
			Update.class }, regexp = "^[mMfFAa]$", message = "O interesse deve ser 'M', 'F' ou 'A'")
	private String interesse;

	@Column(name = "cidade")
	@Size(groups = { Create.class, Update.class }, min = 3, message = "A cidade deve ter no mínimo 3 caracteres")
	private String cidade;

	@Column(name = "estado")
	@Pattern(groups = { Create.class,
			Update.class }, regexp = "^[a-zA-Z]{2}$", message = "O estado deve conter exatamente duas letras")
	private String estado;

	@Size(groups = { Create.class, Update.class }, min = 2, message = "A profissao deve ter no mínimo 2 caracteres")
	@Column(name = "profissao")
	private String profissao;

	@Size(groups = { Create.class, Update.class }, min = 2, message = "A escolaridade deve ter no mínimo 2 caracteres")
	@Column(name = "escolaridade")
	private String escolaridade;

	@Size(groups = { Create.class, Update.class }, min = 2, message = "A descricao deve ter no mínimo 2 caracteres")
	@Column(name = "descricao")
	private String descricao;

	@Size(groups = { Create.class, Update.class }, min = 2, message = "Os lugares deve ter no mínimo 2 caracteres")
	@Column(name = "lugares")
	private String lugares;

}
