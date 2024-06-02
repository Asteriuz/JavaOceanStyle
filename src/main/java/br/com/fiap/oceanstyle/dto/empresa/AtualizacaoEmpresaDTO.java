package br.com.fiap.oceanstyle.dto.empresa;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AtualizacaoEmpresaDTO(
        @NotBlank(message = "O CNPJ não pode estar em branco")
        @Size(min = 14, max = 14, message = "O CNPJ deve ter 14 caracteres")
        @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter apenas dígitos")
        String cnpj,

        @NotBlank(message = "O nome não pode estar em branco")
        @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
        String nome,

        @NotBlank(message = "O telefone não pode estar em branco")
        @Size(min = 10, max = 14, message = "O telefone deve ter entre 10 e 14 caracteres")
        String telefone,

        @NotBlank(message = "O email não pode estar em branco")
        @Email(message = "Formato de email inválido")
        String email) {
}
