package br.com.agenda.domain.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {

	@NotNull
	@Size(min = 1, max = 50)
	@Pattern(regexp = "[A-Z]*")
	private String name;
}