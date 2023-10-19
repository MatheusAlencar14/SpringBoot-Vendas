package com.dev.service.impl;

import com.dev.domain.entity.Cliente;
import com.dev.domain.entity.ItemPedido;
import com.dev.domain.entity.Pedido;
import com.dev.domain.entity.Produto;
import com.dev.domain.repository.ClientesRepository;
import com.dev.domain.repository.ItensPedidosRepository;
import com.dev.domain.repository.PedidosRepository;
import com.dev.domain.repository.ProdutosRepository;
import com.dev.exception.RegraNegocioException;
import com.dev.rest.dto.ItemPedidoDTO;
import com.dev.rest.dto.PedidoDTO;
import com.dev.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor //Lombok: Cria construtor com todos atributos final
public class PedidoServiceImpl implements PedidoService {

    private final PedidosRepository pedidosRepository;
    private final ClientesRepository clientesRepository;
    private final ProdutosRepository produtosRepository;
    private final ItensPedidosRepository itensPedidosRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO pedidoDTO) {
        Integer idCliente = pedidoDTO.getIdCliente();
        Cliente cliente = clientesRepository
                .findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException("Codigo de Cliente inválido"));

        Pedido pedido = new Pedido();
        pedido.setTotal(pedidoDTO.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itensPedidos = converterItens(pedido, pedidoDTO.getItens());
        pedidosRepository.save(pedido);
        itensPedidosRepository.saveAll(itensPedidos);
        pedido.setItens(itensPedidos);
        return pedido;
    }

    private List<ItemPedido> converterItens(Pedido pedido, List<ItemPedidoDTO> itens) {
        if (itens.isEmpty()) {
            throw new RegraNegocioException("Não é possível realizar um pedido sem itens.");
        }

        return itens
                .stream()
                .map(dto -> {
                    Integer idProduto = dto.getIdProduto();
                    Produto produto = produtosRepository
                            .findById(idProduto)
                            .orElseThrow(() -> new RegraNegocioException(
                                    "Codigo de Produto inválido:" + idProduto)
                            );

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).collect(Collectors.toList());
    }
}
