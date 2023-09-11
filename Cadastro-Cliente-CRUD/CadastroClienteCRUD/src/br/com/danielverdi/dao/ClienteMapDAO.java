package br.com.danielverdi.dao;

import br.com.danielverdi.domain.Cliente;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class ClienteMapDAO implements IClienteDAO {

    private Map<Long, Cliente> map = new TreeMap<>();

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if(map.containsKey(cliente.getCpf())) {
            return false;
        }
        map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public void excluir(Long cpf) {
        map.remove(cpf);
    }

    @Override
    public void alterar(Cliente cliente) {
        Long cpf = cliente.getCpf();
        if (map.containsKey(cpf)){
            map.put(cpf, cliente);
        }
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return map.values();
    }
}
