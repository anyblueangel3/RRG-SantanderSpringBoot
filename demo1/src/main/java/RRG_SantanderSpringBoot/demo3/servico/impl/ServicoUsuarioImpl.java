package RRG_SantanderSpringBoot.demo3.servico.impl;

import RRG_SantanderSpringBoot.demo3.dominio.model.Usuario;
import RRG_SantanderSpringBoot.demo3.dominio.repositorio.RepositorioUsuario;
import RRG_SantanderSpringBoot.demo3.servico.ServicoUsuario;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ServicoUsuarioImpl implements ServicoUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public ServicoUsuarioImpl(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    @Override
    public Usuario encontrePeloCpf(Long cpf) {
        return repositorioUsuario.findById(cpf).orElseThrow(NoSuchElementException::new) ;
    }

    @Override
    public Usuario cria(Usuario usuarioParaCriar) {
        if (usuarioParaCriar.getCpf() == null || repositorioUsuario.existsById(usuarioParaCriar.getCpf())) {
            throw new IllegalArgumentException("Esse CPF já está cadastrado, ou CPF passado como nulo!");
        }
        return repositorioUsuario.save(usuarioParaCriar);
    }

}
