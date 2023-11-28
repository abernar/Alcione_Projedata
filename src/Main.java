/*
Projeto Java do teste para desenvolvedor da ProjeData - Teste Prático - Iniflex
Autor: Alcione Bernardinelli
Data: 28/11/2023
*/
import controller.Operacao;
import model.Funcionario;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Operacao operacoes = new Operacao();

        System.out.println("item 3.1 - Inserir todos os funcionários, na mesma ordem e informações da tabela");
        operacoes.inserir(new Funcionario("Maria",  LocalDate.of(2018, 07, 22), new BigDecimal(2009.44),"Operador"));
        operacoes.inserir(new Funcionario("João",   LocalDate.of(1990, 5, 12), new BigDecimal(2284.38),"Operador"));
        operacoes.inserir(new Funcionario("Caio",   LocalDate.of(1961, 5, 2 ), new BigDecimal(9836.14),"Coordenador"));
        operacoes.inserir(new Funcionario("Miguel", LocalDate.of(1988, 10, 14 ), new BigDecimal(19119.88),"Diretor"));
        operacoes.inserir(new Funcionario("Alice",  LocalDate.of(1995, 1, 5   ), new BigDecimal(2234.68),"Recepcionista"));
        operacoes.inserir(new Funcionario("Heitor", LocalDate.of(1999, 11, 19 ), new BigDecimal(1582.72),"Operador"));
        operacoes.inserir(new Funcionario("Arthur", LocalDate.of(1993, 3, 13  ), new BigDecimal(4071.84),"Contador"));
        operacoes.inserir(new Funcionario("Laura",  LocalDate.of(1994, 7, 8   ), new BigDecimal(3017.45),"Gerente"));
        operacoes.inserir(new Funcionario("Heloísa",LocalDate.of(2002, 5, 24  ), new BigDecimal(1606.85),"Eletricista"));
        operacoes.inserir(new Funcionario("Helena", LocalDate.of(1996, 5, 24  ), new BigDecimal(2799.93),"Gerente"));
        operacoes.imprimeListaFuncionarios();
        // item 3.1 fim

        System.out.println("\nItem 3.2 - remover funcionário João");
        operacoes.removerFuncionario("João");

        System.out.println("\nItem 3.3 - imprime lista de funcionários");
        operacoes.imprimeListaFuncionarios();

        System.out.println("\nItem 3.4 - Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor");
        operacoes.aumentoSalario(new BigDecimal(10));
        operacoes.imprimeListaFuncionarios();

        System.out.println("\nItem 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a função e o valor a lista de funcionários");
        System.out.println("Item 3.6 – Imprimir os funcionários agrupados por função");
        operacoes.copiaLista(); // copia lista para um MAP
        operacoes.imprimeListaFuncionariosPorFuncao();

        System.out.println("\n3.7 – Não tem o item 3.7");

        System.out.println("\n3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12");
        operacoes.imprimirFuncMesNasc(12);
        operacoes.imprimirFuncMesNasc(10);

        System.out.println("\n3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade");
        operacoes.imprimirFuncMaisVelho();

        System.out.println("\n3.10 – Imprimir a lista de funcionários por ordem alfabética");
        operacoes.ordenaLista(1);
        operacoes.imprimeListaFuncionarios();

        System.out.println("\n3.11 – Imprimir o total dos salários dos funcionários");
        operacoes.imprimeSomaSalario();

        System.out.println("\n3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00");
        operacoes.imprimeFuncionariosQtdSalariosMininos(1212);
    }
}