package br.com.paqueradebar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleName {

	ADMIN, USER;

	@Override
	public String toString() {
		return this.name();
	}

}
