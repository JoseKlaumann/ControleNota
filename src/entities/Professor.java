/* Criei uma lista de alunos onde eles serao adicionados no programa principal
 * (Conceito da composicao - O professor tem um ou varios alunos) 
 * O professor e responsavel por calcular a media do aluno e da turma
 */
package entities;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Professor { 
	
	DecimalFormat dec = new DecimalFormat("0.00");
	
	private String nome;
	private String disciplina;
	
	private List<Aluno> alunos = new ArrayList<>();
	
	public Professor() {
	}

	public Professor(String nome, String disciplina) {
		this.nome       = nome;
		this.disciplina = disciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void addAluno(Aluno aluno){
		alunos.add(aluno);
	}
	
	public void removeAluno(Aluno aluno) {
		alunos.remove(aluno);
	}
	
	//Calcula qual a melhor media da turma
	public float melhorMedia() {
		float melhorMedia = 0f;		
		for (Aluno alu : alunos) {
			if (alu.media() > melhorMedia) {
				melhorMedia = alu.media();
			}
		}
		return melhorMedia;
	} 
	
	//Calcula a media da turma
	public float mediaTurma() {
		float soma = 0f;
		for (Aluno alu : alunos) {
			soma += alu.media(); 
		}
		return soma / alunos.size();
	} 
		
	/* Mostra no console o nome do professor, a disciplina que ele leciona
	 * O nome do aluno, a serie, o toString da classe aluno
	 * A melhor media da turma e a media geral da turma
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome do professor: ");
		sb.append(nome + "\n");
		sb.append("Disciplina: ");
		sb.append(disciplina + "\n");
		for (Aluno alu : alunos) {
			sb.append("\nNome do aluno: ");
			sb.append(alu.getNome() + "\n");
			sb.append("Serie: ");
			sb.append(alu.getSerie() + "ª\n");
			sb.append(alu.toString());		
		}
		sb.append("\nMelhor media: ");
		sb.append(dec.format(melhorMedia()) + "\n");		
		sb.append("Media da turma: ");
		sb.append(dec.format(mediaTurma()));
		return sb.toString();
	}
}
