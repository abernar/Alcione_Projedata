package controller;
import model.Funcionario;
import java.util.Comparator;

public class OrdenaPorFuncao implements Comparator<Funcionario> {
    @Override
    public int compare(Funcionario func1, Funcionario func2) {
        return func1.getFuncao().compareTo(func2.getFuncao());
    }
}
