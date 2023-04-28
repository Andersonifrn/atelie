package br.edu.ifrn.atelie.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.ifrn.atelie.Modelo.ClienteModel;
import br.edu.ifrn.atelie.Modelo.Servicos;
import br.edu.ifrn.atelie.Modelo.Usuario;
// Essa interface ira manipular os dados no banco de dados
@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer>{

	// BUSCANDO POR NOME, TELEFONE,ENDERECO 
		@Query("select u from ClienteModel u where u.nome like %:nome%"+
				" and u.telefone like %:telefone% and u.endereco like %:endereco%")
		List<ClienteModel> findByNomeAndTelefoneAndEndereco(@Param("nome")String nome,
				                         @Param("telefone")String telefone,
				                         @Param("endereco")String endereco);
		
		
		// BUSCANDO PELO NOME DO CLIENTE
		@Query("select v from ClienteModel v where v.nome like %:nome%")
		 List<ClienteModel> findByNome(@Param("nome")String nome);
		
		// listando todos clientes pelo id do usuário
    	@Query("SELECT x FROM ClienteModel x WHERE x.usuario = ?1")
     	List<ClienteModel> listaClientesPeloIdUsuario(@Param("usuario")Usuario us);
    
    	// lista o nome do cliente por nome informado
     	@Query("SELECT x FROM ClienteModel x WHERE x.nome =?1")
     	List<ClienteModel> listaClientePeloNome(@Param("nome")String nome);
     
}
