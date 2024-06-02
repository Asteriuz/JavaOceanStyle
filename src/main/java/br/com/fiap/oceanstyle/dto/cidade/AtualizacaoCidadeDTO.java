package br.com.fiap.oceanstyle.dto.cidade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AtualizacaoCidadeDTO(
        @NotBlank(message = "O nome não pode estar em branco") @Size(min = 2, max = 10, message = "O nome deve ter entre 2 e 100 caracteres") String nome) {
}
