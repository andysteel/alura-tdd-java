package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReajusteServiceTest {

    @Test
    void reajusteDeveSerDe3PorCentoQuandoDesempenhoForADesejar() {
        ReajusteService service = new ReajusteService();
        var funcionario = new Funcionario("Anderson", LocalDate.now(), new BigDecimal("1000"));
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal(("1030.00")), funcionario.getSalario());
    }

    @Test
    void reajusteDeveSerDe15PorCentoQuandoDesempenhoForBom() {
        ReajusteService service = new ReajusteService();
        var funcionario = new Funcionario("Anderson", LocalDate.now(), new BigDecimal("1000"));
        service.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal(("1150.00")), funcionario.getSalario());
    }

    @Test
    void reajusteDeveSerDe20PorCentoQuandoDesempenhoForOtimo() {
        ReajusteService service = new ReajusteService();
        var funcionario = new Funcionario("Anderson", LocalDate.now(), new BigDecimal("1000"));
        service.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal(("1200.00")), funcionario.getSalario());
    }
}