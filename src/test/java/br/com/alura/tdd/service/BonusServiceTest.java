package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveSerZeroParaSalarioAcimaDe1000() {
        var service = new BonusService();
        var funcionario = new Funcionario("Anderson", LocalDate.now(), new BigDecimal("25000"));
        var bonus = service.calcularBonus(funcionario);

        assertEquals(new BigDecimal("0.00"), bonus);
    }

    @Test
    void bonusDeveSer10PorCentoDoSalario() {
        var service = new BonusService();
        var funcionario = new Funcionario("Anderson", LocalDate.now(), new BigDecimal("2500"));
        var bonus = service.calcularBonus(funcionario);

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveSer10PorCentoParaSalarioDeExatamente10000() {
        var service = new BonusService();
        var funcionario = new Funcionario("Anderson", LocalDate.now(), new BigDecimal("10000"));
        var bonus = service.calcularBonus(funcionario);

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}