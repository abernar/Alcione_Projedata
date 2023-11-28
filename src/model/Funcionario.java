package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;

public class Funcionario extends Pessoa implements Comparable<Object> {
    private BigDecimal salario;
    private String funcao;

    public BigDecimal getSalario() {
        return salario;
    }

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", salário = " + NumberFormat.getCurrencyInstance().format(salario) +
                ", função = " + funcao;
    }

    @Override
    public int compareTo(Object o) {
        Funcionario func = (Funcionario) o;
        return this.getNome().compareTo(func.getNome());
    }

}
