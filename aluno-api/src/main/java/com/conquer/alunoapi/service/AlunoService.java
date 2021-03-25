package com.conquer.alunoapi.service;

import org.springframework.stereotype.Service;

import com.conquer.conquerutils.dto.AlunoDto;

@Service
public class AlunoService {

	public boolean registrarAluno(AlunoDto aluno) {
		return true;
	}
	
	
	public AlunoDto consultarAluno(String cpf) {
		AlunoDto aluno = new AlunoDto();
		
		return aluno;
	}
}
