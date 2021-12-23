package aplication;

import java.util.Scanner;

import entities.Aluno;
import entities.Nota;
import entities.Professor;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char  alu, note;
		
		System.out.print("Nome do professor(a): ");
		String nomeProf = sc.next();
		System.out.print("Disciplina: ");
		String disciplina = sc.next();
		
		Professor prof = new Professor(nomeProf, disciplina);
		
		do {
			System.out.print("Nome do aluno(a): ");
			String nomeAlu = sc.next();
			System.out.print("Serie: ");
			int serie = sc.nextInt();
			
			Aluno aluno = new Aluno(nomeAlu, serie);
			
			prof.addAluno(aluno);
			
			do {
				System.out.print("Entre com a nota do aluno(a): ");
				float nota = sc.nextFloat();
				
				Nota notas = new Nota(nota);
				
				aluno.addNota(notas);
				
				System.out.print("Deseja cadastrar mais uma nota (S/N)? ");
				note = sc.next().toUpperCase().charAt(0);
				
			} while (note != 'N');
			
			System.out.print("Deseja cadastrar mais uma aluno(a) (S/N)? ");
			alu = sc.next().toUpperCase().charAt(0);
			
		} while (alu != 'N');
		
		System.out.println();
		System.out.println(prof.toString());
		
		sc.close();
	}

}
