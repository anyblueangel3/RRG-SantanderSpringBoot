package RRG_SantanderSpringBoot.demo3.servico;

import RRG_SantanderSpringBoot.demo3.dominio.model.Usuario;

public interface ServicoUsuario {

    abstract Usuario encontrePeloCpf(Long cpf);

    abstract Usuario cria(Usuario usuarioParaCriar);

}
