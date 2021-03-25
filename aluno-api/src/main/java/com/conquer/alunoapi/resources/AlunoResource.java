package com.conquer.alunoapi.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conquer.alunoapi.service.AlunoService;
import com.conquer.conquerutils.dto.AlunoDto;
import com.google.gson.Gson;

@RestController
public class AlunoResource {

	@Autowired
	private AlunoService alunoService;
	
	@PostMapping(path = "/registrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registrarAluno(@RequestBody AlunoDto aluno, HttpServletRequest request){
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(aluno));
		
		if(this.alunoService.registrarAluno(aluno)) {
			return ResponseEntity.ok().body(aluno);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(aluno);
		}
		
	}
	
	@GetMapping(value = "/consultar", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> consultarAluno(@RequestParam("cpf") String cpf){
		
		AlunoDto alunoDto = this.alunoService.consultarAluno(cpf);
		
		return ResponseEntity.ok().body(alunoDto);
	}
}
