package br.com.fiap.oceanstyle.controller;

import br.com.fiap.oceanstyle.dto.endereco.DetalhesEnderecoDTO;
import br.com.fiap.oceanstyle.model.Endereco;
import br.com.fiap.oceanstyle.repository.EnderecoRepository;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
@Tag(name = "Enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/buscar")
    public ResponseEntity<List<Endereco>> buscarPorCep(@RequestParam("cep") String cep) {
        var enderecos = enderecoRepository.buscarPorCep(cep);
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping
    public ResponseEntity<Page<DetalhesEnderecoDTO>> pesquisar(Pageable pageable) {
        var page = enderecoRepository.findAll(pageable).map(DetalhesEnderecoDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesEnderecoDTO> pesquisar(@PathVariable("id") Long id) {
        var endereco = new DetalhesEnderecoDTO(enderecoRepository.getReferenceById(id));
        return ResponseEntity.ok(endereco);
    }
}
