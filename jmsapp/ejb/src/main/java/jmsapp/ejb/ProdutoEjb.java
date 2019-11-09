package jmsapp.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jmsapp.modelo.Produto;

@Stateless //Define a classe como EJB sem estado
@TransactionManagement(TransactionManagementType.CONTAINER) // Guarda no banco as transações da classe. (As transações serão guardadas pelo container.)
public class ProdutoEjb {
	@PersistenceContext(unitName = "jmsapp") // armazena os objetos (entidades) que estão sendo manipulados pelo EntityManager corrente.
	private EntityManager em;
	
	public Produto add(Produto produto) {
		em.persist(produto);
		em.flush();
		return produto;
	}

}
