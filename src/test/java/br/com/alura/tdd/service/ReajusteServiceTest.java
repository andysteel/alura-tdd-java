package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReajusteServiceTest {

    private ReajusteService reajusteService;
    private Funcionario funcionario;

    @BeforeEach
    public void init() {
        this.reajusteService = new ReajusteService();
        this.funcionario = new Funcionario("Anderson", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    void reajusteDeveSerDe3PorCentoQuandoDesempenhoForADesejar() {

        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal(("1030.00")), funcionario.getSalario());
    }

    @Test
    void reajusteDeveSerDe15PorCentoQuandoDesempenhoForBom() {

        reajusteService.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal(("1150.00")), funcionario.getSalario());
    }

    @Test
    void reajusteDeveSerDe20PorCentoQuandoDesempenhoForOtimo() {

        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal(("1200.00")), funcionario.getSalario());
    }
}
