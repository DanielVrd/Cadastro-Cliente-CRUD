package br.com.danielverdi.dao;

import br.com.danielverdi.domain.Cliente;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ClienteSetDAO implements IClienteDAO{

    private Set<Cliente> set;

    public ClienteSetDAO() {
        this.set = new HashSet<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        return this.set.add(cliente);
    }

    @Override
    public Cliente consultar(Long cpf) {
        for (Cliente clienteCadastrado : this.set) {
            if (clienteCadastrado.getCpf().equals(cpf)) {
                return clienteCadastrado;
            }
        }
        return null;
    }

    @Override
    public void excluir(Long cpf) {
        this.set.removeIf(cliente -> cliente.getCpf().equals(cpf));
    }

    @Override
    public void alterar(Cliente cliente) {
        if (this.set.contains(cliente)) {
            this.set.remove(cliente);
            this.set.add(cliente);
        }
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.set;
    }
}
