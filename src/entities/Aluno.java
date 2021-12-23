/* Criei uma lista das notas de cada aluno
 * onde la no programa principal vai adicionar cada uma individualmente 
 * (Conceito de composicao - O aluno pode ter uma ou mais notas)
 */

package entities;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import entities.enuns.Situacao;

public class Aluno {

	DecimalFormat dec = new DecimalFormat("0.00");
	
	private String  nome;
	private Integer serie;
	
	private Situacao situacao;
	private List<Nota> notas = new ArrayList<>();
	
	public Aluno() {
	}

	public Aluno(String nome, Integer serie) {
		this.nome = nome;
		this.serie = serie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getSerie() {
		return serie;
	}

	public void setSerie(Integer serie) {
		this.serie = serie;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	public List<Nota> getNotas(){
		return notas;
	}
	
	public void addNota(Nota nota) {
		notas.add(nota);
	}
	
	public void removeNota(Nota nota) {
		notas.remove(nota);
	}
	
	//Calcula a media do aluno e em qual situacao ele se encontra (Aprovado - Em recuperacao - Reprovado)
	public float media() {
		float somaNotas  = 0f;
		int   contaNotas = 0;
		for(Nota nota : notas) {
			somaNotas += nota.getNota();
			contaNotas++;
		}
		
		float media = somaNotas / contaNotas;
		
		//Testa a situacao do aluno
		if (media < 6) {
			setSituacao(Situacao.REPROVADO);
		}
		if (media >= 6 && media <= 7.5) {
			setSituacao(Situacao.EM_RECUPERACAO);
		}
		if (media > 7) {
			setSituacao(Situacao.APROVADO);
		}	
				
		return media;
	}

	//Mostra no console as notas individualmente, a media e a situacao de cada aluno
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Notas: ");
		for (Nota nota : notas) {
			sb.append("\n" + nota.getNota());
		}
		sb.append("\nMedia do aluno(a): ");
		sb.append(dec.format(media()) + "\n");
		sb.append("Situacao: ");
		sb.append(getSituacao().toString() + "\n");
		return sb.toString();
	}
}
