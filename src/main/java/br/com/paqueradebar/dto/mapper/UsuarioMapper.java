package br.com.paqueradebar.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.paqueradebar.dto.UserAdditionalInfoDTO;
import br.com.paqueradebar.dto.UserDTO;
import br.com.paqueradebar.dto.UserRegistrationDTO;
import br.com.paqueradebar.model.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	UserAdditionalInfoDTO toAdditionalInfoDTO(Usuario usuario);

	Usuario toEntity(UserAdditionalInfoDTO usuarioDTO);

	UserDTO toUserDTO(Usuario usuario);

	Usuario toEntity(UserDTO usuarioDTO);

	UserRegistrationDTO toUserRegistrationDTO(Usuario usuario);

	Usuario toEntity(UserRegistrationDTO usuarioDTO);

	// Mapeamento de listas
	List<UserAdditionalInfoDTO> toListAdditionalInfoDTO(List<Usuario> usuarios);

	List<Usuario> toListEntityFromUserAdditionalInfoDTO(List<UserAdditionalInfoDTO> usuarioDTOs);

	List<UserDTO> toListUserDTO(List<Usuario> usuarios);

	List<Usuario> toListEntityFromUserDTO(List<UserDTO> usuarioDTOs);

	List<UserRegistrationDTO> toListUserRegistrationDTO(List<Usuario> usuarios);

	List<Usuario> toListEntityFromUserRegistrationDTO(List<UserRegistrationDTO> usuarioDTOs);

}
