package com.dev.rest.controller;

import com.dev.domain.entity.ItemPedido;
import com.dev.domain.entity.Pedido;
import com.dev.domain.enums.StatusPedido;
import com.dev.exception.RegraNegocioException;
import com.dev.rest.dto.AtualizarStatusPedidoDTO;
import com.dev.rest.dto.InfoItemPedidoDTO;
import com.dev.rest.dto.InfoPedidoDTO;
import com.dev.rest.dto.PedidoDTO;
import com.dev.service.PedidoService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody @Valid PedidoDTO pedidoDTO) {
        Pedido pedido = service.salvar(pedidoDTO);
        return pedido.getId();
    }

    @GetMapping("{id}")
    public InfoPedidoDTO getById(@PathVariable Integer id) {
        return service
                .obterPedidoCompleto(id)
                .map(p -> converter(p))
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Pedido não encontrado."))    ;
    }

    @PatchMapping("{id}") //Faz atualização parcial do objeto,
    @ResponseStatus(NO_CONTENT)
    public void updateStatus(@PathVariable Integer id,
                             @RequestBody @Valid AtualizarStatusPedidoDTO statusAtualizado) {
        String novoStatus = statusAtualizado.getNovoStatus();
        service.atualizarStatus(id, StatusPedido.valueOf(novoStatus));
    }

    private InfoPedidoDTO converter(Pedido pedido) {
        return InfoPedidoDTO
                .builder()
                .codigo(pedido.getId())
                .dataPedido(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .cpf(pedido.getCliente().getCpf())
                .nomeCliente(pedido.getCliente().getNome())
                .total(pedido.getTotal())
                .status(pedido.getStatus().name())
                .itens(converterItens(pedido.getItens()))
                .build();
    }

    private List<InfoItemPedidoDTO> converterItens(List<ItemPedido> list) {
        if(CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(itens -> InfoItemPedidoDTO
                .builder()
                .descricaoProduto(itens.getProduto().getDescricao())
                .precoUnitario(itens.getProduto().getPreco())
                .quantidade(itens.getQuantidade())
                .build()
        ).collect(Collectors.toList());
    }
}
