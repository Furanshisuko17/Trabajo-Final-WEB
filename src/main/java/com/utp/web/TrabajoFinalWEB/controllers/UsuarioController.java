package com.utp.web.TrabajoFinalWEB.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.utp.web.TrabajoFinalWEB.models.entity.Registro;
import com.utp.web.TrabajoFinalWEB.services.RegistroService;

@Controller
public class UsuarioController {
	
	@Autowired
	private RegistroService registroService;

	@Autowired
	private RegistroService registroService;

	@GetMapping("/usuario")
	public String mainUsuario(Model model) {
		
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

		String dni= "";

		Object principal= authentication.getPrincipal();
		if(principal instanceof UserDetails){
			dni= ((UserDetails) principal).getUsername();
		}else{
			dni= principal.toString();
		}
		
		List<Registro> registros = registroService.listarporDni(dni);
		
		model.addAttribute("registros", registros);
		
		return "usuario";
	}
	
	
	
}
