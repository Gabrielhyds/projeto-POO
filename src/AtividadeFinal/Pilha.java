package AtividadeFinal;

import java.util.LinkedList;
import AtividadeFinal.Senha;

public class Pilha extends EstrategiaLIFO {
	
	//atributos
	protected LinkedList<Senha> pilha;
	private TipoLista tipoLista;
	
	//construtor
	Pilha(TipoLista tipo){
        this.pilha = new LinkedList<Senha>();
		this.tipoLista = tipo;	
	}

	//metodo para retornar o tamanho da pilha
    public int tamanho() {
        return this.pilha.size();
    }

	//metodos getter/setter do tipoLista
	public TipoLista getTipoLista() {
		return tipoLista;
	}

	public void setTipoLista(TipoLista tipoLista) {
		this.tipoLista = tipoLista;
	}
	//metodos INSERIR - REMOVER - CHAMAR - ATENDER - LISTAR
	@Override
	public String inserir() {
		 Senha senha = new Senha(); // instancia a senha
	     senha.gerarSenha(); // Gera a próxima senha na sequência
	     pilha.addFirst(senha); // adiciona a senha gerada na pilha
	     return pilha.toString(); // retorna a pilha em string
    }
	@Override
	public void remover() {
	    if (!pilha.isEmpty()) { //se a pilha for diferente de vazio
	        pilha.removeFirst(); // remove o primeiro elemento do topo da pilha
	    }
	}
	@Override
	public String chamar() {
	    if (!pilha.isEmpty()) { // se a pilha for diferente de vazio
	        Senha senha = pilha.getFirst(); // pega a primeira senha do topo da pilha
	        senha.setChamado(); // Marca a senha como chamada usando o metodo setchamado ex: 0001*
	        return senha.retornarSenha(); // retorna a senha
	    } else {
	        return "Não há senhas na fila."; // se a pilha estiver vazia retorna essa string
	    }
	}
	//metodo para ver se pilha está vazia
	 public boolean estaVazia() {
		 	boolean aux = false; // variavel bool iniciada em false
		 	if(tamanho() == 0) { // se a função tamanho for igual a 0 então:
		 		 aux = true; // atribui a variavel aux o valor true
		 	}
		 	return aux; // retorna o valor da varivel aux TRUE OR FALSE
	}
	public String atender() { 
	  if (!pilha.isEmpty()) { // Se a pilha não estiver vazia
	        Senha senha = pilha.removeFirst(); // remove a primeira senha do topo da pilha
	        senha.getChamado(); ; // Marca a senha como chamada
	        return senha.retornarSenha(); // Retorna a senha atendida
	    } else {
	        return "Não há senhas na fila."; // se a pilha estiver vazia retorna essa string
		}
	}
	@Override
	public String listar() { 
		String listaSenhas = ""; // declara uma varivel vazia do tipo string
	    for (Senha senha : pilha) { // Itera sobre cada objeto Senha na pilha
	        listaSenhas += senha.retornarSenha() + "\n";  // Concatena a senha atual com uma nova linha à lista de senhas
	    }
	    return listaSenhas; // Retorna a lista completa de senhas
	} 
	
	
   
}
