package com.samuel.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.samuel.cursomc.domain.Categoria;
import com.samuel.cursomc.domain.Cidade;
import com.samuel.cursomc.domain.Cliente;
import com.samuel.cursomc.domain.Endereco;
import com.samuel.cursomc.domain.Estado;
import com.samuel.cursomc.domain.Produto;
import com.samuel.cursomc.domain.enums.TipoCliente;
import com.samuel.cursomc.repository.CategoriaRepository;
import com.samuel.cursomc.repository.CidadeRepository;
import com.samuel.cursomc.repository.ClienteRepository;
import com.samuel.cursomc.repository.EnderecoRepository;
import com.samuel.cursomc.repository.EstadoRepository;
import com.samuel.cursomc.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"Sao Paulo");
		
		Cidade c1 = new Cidade (null, "Uberlandia", est1);
		Cidade c2 = new Cidade (null, "Sao Paulo", est2);
		Cidade c3 = new Cidade (null, "Campinas", est2);
		
		Cliente cli1 = new Cliente (null, "Maria Silva", "maria@gmail.com", "3637891377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("2736-3323","9383-8393"));
		Endereco e1 = new Endereco (null, "Rua flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco (null, "Avenida Matos","105", "Sala 800", "Centro", "38777012", cli1 , c2);
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
	}

}
