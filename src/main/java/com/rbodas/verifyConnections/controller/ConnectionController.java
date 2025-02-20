package com.rbodas.verifyConnections.controller;

import java.io.IOException;
import java.net.UnknownHostException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.stream.Collectors;

import com.rbodas.verifyConnections.entities.VerificarPuertosAbiertos;
import com.rbodas.verifyConnections.models.Connection;

@Controller
public class ConnectionController {

	@GetMapping("/abrircheckport")  
    public String getPageCheckPort(Model model) {
		Connection conn = new Connection();
		model.addAttribute("conn", conn);
		model.addAttribute("title", "Comprobar puertos");

        return "checkport";
    }
	
	@GetMapping("/abrircheckports")  
    public String getPageCheckPorts(Model model) {
		Connection conn = new Connection();
		model.addAttribute("conn", conn);
		model.addAttribute("title", "Comprobar puertos");

        return "checkports";
    }
	
	@PostMapping("/checkPort")  
    public String detailsModel(Model model, Connection conn) {
		VerificarPuertosAbiertos vpa = new VerificarPuertosAbiertos();
		conn.setRespuestaPort(vpa.checkOpenPort(conn.getPuerto()));
		
		model.addAttribute("conn", conn);
		model.addAttribute("title", "Comprobar puertos");

        return "checkport";
    }
	
	@GetMapping("/checkPorts")  
    public String detailsModel1(Model model, Connection conn) throws UnknownHostException, IOException {
		VerificarPuertosAbiertos vpa = new VerificarPuertosAbiertos();
		//conn.setRespuestaPorts(vpa.checkOpenPorts());
	    String puertos = vpa.checkOpenPorts().stream()
                .map(Connection::getPuerto)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

	    System.out.println(puertos);
		model.addAttribute("puertos", puertos);
		model.addAttribute("title", "Puertos abiertos");

        return "checkports";
    }
	
}
