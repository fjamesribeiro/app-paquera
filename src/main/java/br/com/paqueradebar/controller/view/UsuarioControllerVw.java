package br.com.paqueradebar.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.paqueradebar.model.Usuario;
import br.com.paqueradebar.service.UsuarioService;


@Controller
@RequestMapping("/user")
public class UsuarioControllerVw {

	@Autowired
	private UsuarioService service;

	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView andView = new ModelAndView("/usuario/create");
		Usuario usuario = new Usuario();
		usuario.setEmail(null);
		andView.addObject("usuario", usuario);
		return andView;
	}
}
