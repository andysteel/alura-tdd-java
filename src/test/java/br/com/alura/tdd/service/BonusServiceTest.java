package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    private BonusService service;

    @BeforeEach
    public void init() {
        this.service = new BonusService();
    }

    @Test
    void bonusDeveLancarExceptionParaSalarioAcimaDe1000() {

        var funcionario = new Funcionario("Anderson", LocalDate.now(), new BigDecimal("25000"));

//        assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(funcionario));

        try {
            service.calcularBonus(funcionario);
            fail("Não lancou exception");
        } catch (IllegalArgumentException ex) {
            assertEquals("Funcionario com salario maior que 10.000 não pode receber Bonus !", ex.getMessage());
        }
    }

    @Test
    void bonusDeveSer10PorCentoDoSalario() {

        var funcionario = new Funcionario("Anderson", LocalDate.now(), new BigDecimal("2500"));
        var bonus = service.calcularBonus(funcionario);

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveSer10PorCentoParaSalarioDeExatamente10000() {

        var funcionario = new Funcionario("Anderson", LocalDate.now(), new BigDecimal("10000"));
        var bonus = service.calcularBonus(funcionario);

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}