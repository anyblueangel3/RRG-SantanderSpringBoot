package RRG_SantanderSpringBoot.demo3.Controle;

import RRG_SantanderSpringBoot.demo3.dominio.model.Usuario;
import RRG_SantanderSpringBoot.demo3.servico.ServicoUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/Usuarios")
public class ControleUsuario {

    private final ServicoUsuario servicoUsuario;

    public ControleUsuario(ServicoUsuario servicoUsuario) {
        this.servicoUsuario = servicoUsuario;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Usuario> EncontrePeloUsuario(@PathVariable Long cpf) {
        var usuario = servicoUsuario.encontrePeloCpf(cpf);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> cria(@RequestBody Usuario usuarioParaCriar) {
        var usuarioCriado = servicoUsuario.cria(usuarioParaCriar);
        URI localizacao = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{cpf}")
                .buildAndExpand(usuarioCriado.getCpf())
                .toUri();
        return ResponseEntity.created(localizacao).body(usuarioCriado);
    }

}
