package br.com.fiap.oceanstyle.dto.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CadastroVeiculoDTO(
        @NotBlank(message = "O nome não pode estar em branco")
        @Size(max = 30, message = "O nome deve ter no máximo 30 caracteres")
        String nome,

        @NotBlank(message = "O tipo não pode estar em branco")
        @Size(max = 50, message = "O tipo deve ter no máximo 50 caracteres")
        String tipo,

        @NotBlank(message = "O tipo do motor não pode estar em branco")
        @Size(max = 50, message = "O tipo do motor deve ter no máximo 50 caracteres")
        String tipoMotor,

        @NotBlank(message = "O sonar não pode estar em branco")
        @Size(max = 50, message = "O sonar deve ter no máximo 50 caracteres")
        String sonar,

        @NotNull(message = "O ID da empresa não pode ser nulo")
        @Positive(message = "O ID da empresa deve ser um número positivo")
        Long empresaId,

        @NotBlank(message = "O link da imagem não pode estar em branco")
        @Size(max = 100, message = "O link da imagem deve ter no máximo 100 caracteres")
        String linkImagem) {
}
