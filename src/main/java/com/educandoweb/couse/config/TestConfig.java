package com.educandoweb.couse.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.couse.entities.Categoria;
import com.educandoweb.couse.entities.ItemPedido;
import com.educandoweb.couse.entities.Pedido;
import com.educandoweb.couse.entities.Produto;
import com.educandoweb.couse.entities.User;
import com.educandoweb.couse.entities.enums.PedidoStatus;
import com.educandoweb.couse.repositories.CategoriaRepository;
import com.educandoweb.couse.repositories.ItemPedidoRepository;
import com.educandoweb.couse.repositories.PedidoRepository;
import com.educandoweb.couse.repositories.ProdutoRepository;
import com.educandoweb.couse.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Override
	public void run(String... args) throws Exception {

		Categoria categoria1 = new Categoria(null, "Electrônicos");
		Categoria categoria2 = new Categoria(null, "Livros");
		Categoria categoria3 = new Categoria(null, "Computadores");

		Produto produto1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5,
				"");
		Produto produto2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto produto3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto produto4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto produto5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99,
				"");

		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));

		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));

		produto1.getCategorias().add(categoria2);
		produto2.getCategorias().add(categoria1);
		produto2.getCategorias().add(categoria3);
		produto3.getCategorias().add(categoria3);
		produto4.getCategorias().add(categoria3);
		produto5.getCategorias().add(categoria2);

		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));

		User usuario1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User usuario2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		userRepository.saveAll(Arrays.asList(usuario1, usuario2));

		Pedido pedido1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.AGUARDANDO_PAGAMENTO,
				usuario1);
		Pedido pedido2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.ENTREGUE, usuario2);
		Pedido pedido3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.PAGO, usuario1);

		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));

		ItemPedido itemPedido1 = new ItemPedido(pedido1, produto1, 2, produto1.getValor());
		ItemPedido itemPedido2 = new ItemPedido(pedido1, produto3, 1, produto3.getValor());
		ItemPedido itemPedido3 = new ItemPedido(pedido2, produto3, 2, produto3.getValor());
		ItemPedido itemPedido4 = new ItemPedido(pedido3, produto5, 2, produto5.getValor());

		itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3, itemPedido4));
	}

}
