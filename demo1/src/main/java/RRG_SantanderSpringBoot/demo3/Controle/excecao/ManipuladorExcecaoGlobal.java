package RRG_SantanderSpringBoot.demo3.Controle.excecao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ManipuladorExcecaoGlobal {

    private final Logger logger = LoggerFactory.getLogger(ManipuladorExcecaoGlobal.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> tratarExcecaoNegocio(IllegalArgumentException excecaoNegocio) {
        return new ResponseEntity<>(excecaoNegocio.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> tratarExcecaoNaoEncontrado(NoSuchElementException excecaoElementoNaoEncontrado) {
        return new ResponseEntity<>("Elemento do CPF não encontrado.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> tratarExcecaoNaoEsperada(Throwable excecaoNaoEsperada) {
        logger.error("", excecaoNaoEsperada);
        var mensagem = "Erro não esperado de servidor, veja os logs.";
        return new ResponseEntity<>(mensagem, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
