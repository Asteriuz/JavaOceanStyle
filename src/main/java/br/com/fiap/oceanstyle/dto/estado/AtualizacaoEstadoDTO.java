package br.com.fiap.oceanstyle.dto.estado;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AtualizacaoEstadoDTO(
        @NotBlank(message = "O nome não pode estar em branco")
        @Size(max = 50, message = "O nome deve ter no máximo 50 caracteres")
        String nome,

        @NotBlank(message = "A sigla não pode estar em branco")
        @Size(max = 2, message = "A sigla deve ter no máximo 2 caracteres")
        String sigla) {
}
