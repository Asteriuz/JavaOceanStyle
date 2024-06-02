package br.com.fiap.oceanstyle.dto.vistoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record AtualizacaoVistoriaDTO(
        @NotNull(message = "A data não pode ser nula")
        LocalDate data,

        @NotNull(message = "O nível de ruído não pode ser nulo")
        Integer nivelRuido,

        @NotBlank(message = "O resultado não pode estar em branco")
        @Size(max = 30, message = "O resultado deve ter no máximo 30 caracteres")
        String resultado,

        @NotBlank(message = "As observações não podem estar em branco")
        @Size(max = 100, message = "As observações devem ter no máximo 100 caracteres")
        String observacoes

      ) {
}
