package com.br.brasilprev.utils;

import com.br.brasilprev.domain.model.Produto;
import com.br.brasilprev.infrastructure.response.ProdutoResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProdutoUtils {

    public static List<ProdutoResponse> getProdutos(List<Produto> produtos) {
        return produtos.stream()
                .map(produto -> new ProdutoResponse(produto.getId(), produto.getNome()))
                .collect(Collectors.toList());
    }
}
