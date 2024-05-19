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
		 Senha senha = new Senha();
	     senha.gerarSenha(); // Gera a próxima senha na sequência
	     pilha.addFirst(senha);
	     return pilha.toString();
    }
	
	@Override
	public void remover() {
	    if (!pilha.isEmpty()) {
	        pilha.removeFirst(); // Remove the top element from the stack
	    }
	}

	@Override
	public String chamar() {
	    if (!pilha.isEmpty()) {
	        Senha senha = pilha.getFirst(); // Get the next password in the stack
	        senha.setChamado(); // Mark the password as called
	        return senha.retornarSenha(); // Return the next password
	    } else {
	        return "Não há senhas na fila.";
	    }
	}

	@Override
	public String atender() {
	    if (!pilha.isEmpty()) {
	        Senha senha = pilha.removeFirst(); // Serve the next password in the stack
	        senha.setChamado(); // Mark the password as called
	        return senha.retornarSenha(); // Return the served password
	    } else {
	        return "Não há senhas na fila.";
	    }
	}
	@Override
	public String listar() {
		 StringBuilder listaSenhas = new StringBuilder();
		    for (Senha senha : pilha) {
		        listaSenhas.append(senha.retornarSenha()).append("\n");
		    }
		    return listaSenhas.toString();
	} 
	
	
   
}
