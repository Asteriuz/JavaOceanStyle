package br.com.fiap.oceanstyle.dto.inspetor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AtualizacaoInspetorDTO(
        @NotBlank(message = "O RG não pode estar em branco")
        @Size(max = 11, message = "O RG deve ter no máximo 11 caracteres")
        String rg,

        @NotBlank(message = "O nome não pode estar em branco")
        @Size(max = 50, message = "O nome deve ter no máximo 50 caracteres")
        String nome,

        @Size(max = 50, message = "A especialização deve ter no máximo 50 caracteres")
        String especializacao,

        @NotBlank(message = "O telefone não pode estar em branco")
        @Size(min = 10, max = 11, message = "O telefone deve ter entre 10 e 11 caracteres")
        String telefone) {
}
