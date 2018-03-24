package br.com.ss.ws.service;

import java.io.IOException;
import java.util.HashMap;

import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ps.rwd.bean.Endereco;

public class CepService {
	
	private Client client;
	
	private static final String URL = "http://api.postmon.com.br/v1/cep/";
	
	public CepService() {
		this.client = Client.create();
	}
	
	public Endereco buscarCep(String cep) throws IOException, ParseException {
		
		WebResource resource = client.resource(URL).path(cep);		
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		String output = response.getEntity(String.class);		
		
		JSONParser parser = new JSONParser();
		JSONObject result = (JSONObject) parser.parse(output);
		JSONObject estadoInfo = (JSONObject) result.get("estado_info");
		
		Endereco endereco = new Endereco();
		endereco.setBairro(String.valueOf(result.get("bairro")));
		endereco.setCidade(String.valueOf(result.get("cidade")));
		endereco.setEstado(String.valueOf(estadoInfo.get("nome")));
		endereco.setLogradouro(String.valueOf(result.get("logradouro")));
		
		return endereco;
		
	}

}
