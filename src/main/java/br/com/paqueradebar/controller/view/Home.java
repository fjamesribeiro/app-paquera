//package br.com.paqueradebar.controller.view;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import br.com.paqueradebar.model.Usuario;
//import br.com.paqueradebar.service.UsuarioService;
//import jakarta.servlet.http.HttpServletRequest;
//
//@Controller
//public class Home {
//
//	@Autowired
//	UsuarioService service;
//
////	@GetMapping("/home")
////	public ModelAndView home(@AuthenticationPrincipal OAuth2AuthenticatedPrincipal authentication) {
////		ModelAndView model = new ModelAndView("/usuario/create");
////		String nome = authentication.getAttribute("given_name");
////		String sobrenome = authentication.getAttribute("family_name");
////		String email = authentication.getAttribute("email");
////
////		Usuario usuario = new Usuario();
////		usuario.setEmail(email);
////		usuario.setNome(nome);
////		usuario.setSobrenome(sobrenome);
////		model.addObject("usuario", usuario);
////
////		return model;
////	}
//
//	@GetMapping("/")
//	public ModelAndView home() {
//		ModelAndView model = new ModelAndView("/usuario/create");
//		Usuario usuario = new Usuario();
//		model.addObject("usuario", usuario);
//		return model;
//	}
//
//	@GetMapping("/login")
//	public String login() {
//		return "login";
//	}
//
//	@GetMapping("/fail")
//	public String fail() {
//		return "fail";
//	}
//
//	@GetMapping("/logout")
//	public String logoutPage() {
//		return "logout"; // Nome do template Thymeleaf (logout.html)
//	}
//
//	@PostMapping("/perform-logout")
//	public String performLogout(HttpServletRequest request) {
//		return "redirect:/login"; // Redireciona para a página inicial ou qualquer outra página
//	}
//
//}
