package controller;
/*
Projeto Java do teste para desenvolvedor da ProjeData - Teste Prático - Iniflex
Autor: Alcione Bernardinelli
Data: 28/11/2023
*/
import model.Funcionario;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.lang.Math.divideExact;

public class Operacao {
    private List<Funcionario> listaFuncionarios = new ArrayList<>();
    private Map<String, ArrayList<Funcionario>> mapaFuncionarios = new HashMap<>();

    public void inserir(Funcionario funcionario) {
        Integer indice = 0;

        if (!listaFuncionarios.isEmpty()) {
            indice = listaFuncionarios.size();
        }
        this.listaFuncionarios.add(funcionario);
    }

    // imprime lista de funcionários
    public void imprimeListaFuncionarios(){

        for (Funcionario func : this.listaFuncionarios) {
            System.out.println(func.toString());
        }
    }

    // método para remover um funcionário pelo nome
    public void removerFuncionario(String nome){

        // localizar pelo nome
        for (Funcionario func : listaFuncionarios) {
            if(func.getNome().equals(nome)) {
                System.out.println("remover: " + func );
                this.listaFuncionarios.remove(func);
                break;
            }
        }
    }

    // ordena a lista de funcinários por nome (parâmetro = 1) ou por função (parâmetro = 2)
    public void ordenaLista(int campoOrdenado){
        if (campoOrdenado == 1) {
            Collections.sort(listaFuncionarios);
        } else if (campoOrdenado == 2) {
            Collections.sort(listaFuncionarios, new OrdenaPorFuncao());
        }
    }

    // imprime lista de funcionários com quebra por função
    public void imprimeListaFuncionariosPorFuncao(){
        for (Map.Entry<String, ArrayList<Funcionario>> listaFunc : mapaFuncionarios.entrySet()) {

            System.out.println("Função: " + listaFunc.getKey());

            for(Funcionario arrayFunc : listaFunc.getValue()){
                System.out.println(arrayFunc.toString());
            }
        }
    }

    // copia lista de funcionários para um Map, sendo a chave a funcão e valor uma lista dos funcionários da respectiva função
    public void copiaLista() {
        String funcaoAtual = "xxxxxx";
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        boolean primeiraVez = true;

        for(Funcionario func : this.listaFuncionarios){

            if (mapaFuncionarios.get(func.getFuncao()) == null) {
                mapaFuncionarios.put(func.getFuncao(), new ArrayList<>());
            }

            mapaFuncionarios.get(func.getFuncao()).add(func);
        }
    }

    // busca e imprime os funcionários nascidos em um determinado mês do ano
    public void imprimirFuncMesNasc(int mes){
        Stream<Funcionario> funcionarioStream = listaFuncionarios.stream();
        System.out.println("Lista de funcionários nascisdos no mês " + mes);
        System.out.println(funcionarioStream.filter(func -> func.getDataNascimento().getMonthValue() == mes).collect(Collectors.toList()));
    }

    // busca e imprime o funcionário mais velho da lista
    // od dados de saída são nome e a idade em anos, mese e dias
    public void imprimirFuncMaisVelho(){
        Stream<Funcionario> funcionarioStream = listaFuncionarios.stream();
        Funcionario funcMaisVelho;

        funcMaisVelho = funcionarioStream.min(Comparator.comparing( func -> func.getDataNascimento().getYear() + func.getDataNascimento().getMonthValue() +
                func.getDataNascimento().getDayOfMonth() )).get() ;
        System.out.println("Funcionário mais velho (" + funcMaisVelho.getDataNascimento().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")).replace('.', '/') + ")");
        System.out.println("Nome: " + funcMaisVelho.getNome() + ", idade: " + idade(funcMaisVelho.getDataNascimento()));
    }

    // calcula e imprime a idade em anos, meses e dias
    public String idade(LocalDate dataNascimento){
        int dias;
        LocalDate hoje = LocalDate.now();

        dias = (hoje.getYear() - dataNascimento.getYear()) * 365 + ((hoje.getMonthValue() - dataNascimento.getMonthValue()) * 30) +
                ((hoje.getDayOfMonth() - dataNascimento.getDayOfMonth()));
        return divideExact(dias, 365) + " anos " + divideExact(dias%365, 30) + " meses " + dias%365%30 + " dias";

    }

    //aumenta o salário dos funcionarios conforme o aumento percentual passado como parâmetro
    public void aumentoSalario(BigDecimal aumentoPorcentual) {
        for (Funcionario func : this.listaFuncionarios){
            func.setSalario(func.getSalario().multiply(aumentoPorcentual.divide(new BigDecimal(100)).add(new BigDecimal(1))));
        }
    }

    // imprime a soma dos salários dos funcionários da lista
    public void imprimeSomaSalario(){
        System.out.println("A soma dos salários é de " + NumberFormat.getCurrencyInstance().format(somaSalario()));
    }

    // calcula a soma dos salários dos funcionários da lista
    public double somaSalario(){
        Stream<Funcionario> funcionarioStream = listaFuncionarios.stream();
        return funcionarioStream.mapToDouble(func ->  func.getSalario().doubleValue()).summaryStatistics().getSum();
    }

    // calcula e imprime a quantidade de salários míniimos dos funcionários, o valor do salário mínimo é passado como parâmetro
    public void imprimeFuncionariosQtdSalariosMininos(double valorSM){

        for (Funcionario func : this.listaFuncionarios) {
            System.out.println("Nome: " + func.getNome()  + ", função: " + func.getFuncao() +
                    ", quantidade de salários mínimos: " + String.format("%.2f", func.getSalario().doubleValue() / valorSM));
        }
    }

}
