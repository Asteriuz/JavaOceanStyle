package br.com.fiap.oceanstyle.controller;

import br.com.fiap.oceanstyle.model.Veiculo;
import br.com.fiap.oceanstyle.dto.veiculo.AtualizacaoVeiculoDTO;
import br.com.fiap.oceanstyle.dto.veiculo.CadastroVeiculoDTO;
import br.com.fiap.oceanstyle.dto.veiculo.DetalhesVeiculoDTO;
import br.com.fiap.oceanstyle.repository.VeiculoRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import br.com.fiap.oceanstyle.repository.EmpresaRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
@Tag(name = "Veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/empresa/{empresaId}")
    public ResponseEntity<List<Veiculo>> buscarPorEmpresa(@PathVariable("empresaId") Long empresaId) {
        var empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada com ID: " + empresaId));
        var veiculos = veiculoRepository.buscarPorEmpresa(empresa);
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Veiculo>> buscar(@RequestParam(required = false) Long empresaId,
            @RequestParam(required = false) String nome) {
        List<Veiculo> veiculos;
        if (empresaId != null && nome != null) {
            var empresa = empresaRepository.findById(empresaId)
                    .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada com ID: " + empresaId));
            veiculos = veiculoRepository.buscarPorNomeEEmpresa(empresa, nome);
        } else if (nome != null) {
            veiculos = veiculoRepository.buscarPorNome(nome);
        } else if (empresaId != null) {
            var empresa = empresaRepository.findById(empresaId)
                    .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada com ID: " + empresaId));
            veiculos = veiculoRepository.buscarPorEmpresa(empresa);
        } else {
            veiculos = veiculoRepository.findAll();
        }
        return ResponseEntity.ok(veiculos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesVeiculoDTO> cadastrar(@RequestBody CadastroVeiculoDTO dto,
            UriComponentsBuilder builder) {
        var veiculo = new Veiculo(dto);
        var empresa = empresaRepository.getReferenceById(dto.empresaId());
        veiculo.setEmpresa(empresa);
        veiculo = veiculoRepository.save(veiculo);
        var uri = builder.path("/veiculos/{id}").buildAndExpand(veiculo.getTie()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesVeiculoDTO(veiculo));
    }

    @GetMapping
    public ResponseEntity<Page<DetalhesVeiculoDTO>> pesquisar(Pageable pageable) {
        var page = veiculoRepository.findAll(pageable).map(DetalhesVeiculoDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesVeiculoDTO> pesquisar(@PathVariable("id") Long id) {
        var veiculo = new DetalhesVeiculoDTO(veiculoRepository.getReferenceById(id));
        return ResponseEntity.ok(veiculo);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesVeiculoDTO> atualizar(@PathVariable("id") Long id,
            @RequestBody AtualizacaoVeiculoDTO dto) {
        var veiculo = veiculoRepository.getReferenceById(id);
        veiculo.atualizar(dto);
        return ResponseEntity.ok(new DetalhesVeiculoDTO(veiculo));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable("id") Long id) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Veículo não encontrado com ID: " + id));
        veiculoRepository.delete(veiculo);
        return ResponseEntity.noContent().build();
    }
}
