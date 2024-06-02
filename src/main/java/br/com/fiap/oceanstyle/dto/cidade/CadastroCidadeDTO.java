package br.com.fiap.oceanstyle.dto.cidade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CadastroCidadeDTO(
        @NotBlank(message = "O nome não pode estar em branco")
        String nome,

        @NotNull(message = "O ID do estado não pode ser nulo")
        @Positive(message = "O ID do estado deve ser um número positivo")
        Long estadoId) {
}
