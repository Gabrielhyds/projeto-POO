package AtividadeFinal;



import java.util.LinkedList;
import AtividadeFinal.Senha;

public class Pilha extends EstrategiaLIFO {
	
	protected LinkedList<Senha> pilha;
	private TipoLista tipoLista;
	
	
	Pilha(TipoLista tipo){
        this.pilha = new LinkedList<Senha>();
		this.tipoLista = tipo;
		
		
	}
	
	public TipoLista getTipoLista() {
		return tipoLista;
	}

	public void setTipoLista(TipoLista tipoLista) {
		this.tipoLista = tipoLista;
	}
	
	@Override
	public String inserir() {
		 Senha senha = new Senha();
	     senha.gerarSenha(); // Gera a próxima senha na sequência
	     pilha.addFirst(senha);
	     return pilha.toString();
    }
	
	@Override
	public void remover() {
		
	}
	@Override
	public String chamar() {
	    return "Não há senhas na pilha.";
	}
	@Override
	public String atender() {
		
        return null;
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
