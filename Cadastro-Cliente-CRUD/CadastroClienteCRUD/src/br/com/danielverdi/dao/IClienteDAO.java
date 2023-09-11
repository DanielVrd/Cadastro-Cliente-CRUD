package br.com.danielverdi.dao;

import br.com.danielverdi.domain.Cliente;

import java.util.Collection;


public interface IClienteDAO {

    Boolean cadastrar (Cliente cliente);

    Cliente consultar (Long cpf);

    void excluir (Long cpf);

    void alterar (Cliente cliente);

    Collection<Cliente> buscarTodos();




}

