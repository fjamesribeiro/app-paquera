//package br.com.paqueradebar.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import br.com.paqueradebar.model.Usuario;
//import br.com.paqueradebar.repository.UsuarioRepository;
//import jakarta.servlet.http.HttpSession;
//import jakarta.transaction.Transactional;
//
//@Service
//public class UserDetailServiceImpl implements UserDetailsService {
//
//	@Autowired
//	HttpSession session; // autowiring session
//
//	@Autowired
//	UsuarioRepository repository;
//
//	@Override
//	@Transactional
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		Usuario usuario = repository.findByEmail(email)
//				.orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado: " + email));
//
//		session.setAttribute("idUsuario", usuario.getId());
//
//		return User.builder()
//				.username(usuario.getEmail())
//				.password(usuario.getSenha())
//				.authorities(usuario.getRoles()).build();
//	}
//
//}
