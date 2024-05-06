package com.br.brasilprev.utils;

import com.br.brasilprev.domain.model.Cliente;
import com.br.brasilprev.infrastructure.response.ClienteResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteUtils {

    public static List<ClienteResponse> getClientes(List<Cliente> clientes) {
        return clientes.stream()
                .map(cliente -> new ClienteResponse(cliente.getId(), cliente.getNome()))
                .collect(Collectors.toList());
    }

}
