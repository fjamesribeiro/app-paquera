package br.com.paqueradebar.controller.view;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import br.com.paqueradebar.model.Usuario;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UsuarioControllerView {

	private RestTemplate restTemplate;

	@PostMapping("/create")
	public String create(@Valid Usuario usuario, BindingResult result, Model model) {
		// Verifica se há erros de validação
		if (result.hasErrors()) {
			return "user/create"; // Volta para o formulário com erros
		}

		try {
			// Chama a API REST para salvar o usuário
			String apiUrl = "http://localhost:8080/api/usuario"; // Exemplo de URL da API REST
			ResponseEntity<Usuario> response = restTemplate.postForEntity(apiUrl, usuario, Usuario.class);

			if (response.getStatusCode() == HttpStatus.CREATED) {
				return "redirect:/user/success"; // Redireciona para uma página de sucesso
			} else {
				model.addAttribute("apiError", "Erro ao criar usuário. Tente novamente.");
				return "user/create"; // Volta para o formulário com mensagem de erro
			}
		} catch (Exception e) {
			model.addAttribute("apiError", "Erro na comunicação com o servidor.");
			return "user/create"; // Retorna com erro de comunicação
		}
	}
}
