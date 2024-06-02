package br.com.fiap.oceanstyle.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CadastroEnderecoDTO(
                @NotBlank(message = "A rua não pode estar em branco") @Size(max = 100, message = "A rua deve ter no máximo 100 caracteres") String rua,

                @NotBlank(message = "O número não pode estar em branco") @Size(max = 10, message = "O número deve ter no máximo 10 caracteres") String numero,

                @NotBlank(message = "O CEP não pode estar em branco") @Size(min = 8, max = 8, message = "O CEP deve ter 8 caracteres") @Pattern(regexp = "\\d{8}", message = "O CEP deve conter apenas dígitos") String cep,

                @NotNull(message = "O ID da cidade não pode ser nulo") @Positive(message = "O ID da cidade deve ser um número positivo") Long cidadeId

) {

}
