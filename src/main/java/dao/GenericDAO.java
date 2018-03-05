package dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import util.HibernateUtil;

public class GenericDAO<Entidade> {

	private Class<Entidade> classe; // toda vez que é instaciada a clesse generica é passado para o classe a classe
									// filha

	@SuppressWarnings("unchecked")
	public GenericDAO() { // API java reflection utilizado para reslver problema do tipo de entidade
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession(); // captura a uma sessão
		Transaction transacao = null; // cria uma transação isso garente que a transaão vai ser completada caso nao
										// complete ele faz um rollback
		try {
			transacao = sessao.beginTransaction(); // transação iniciado
			sessao.save(entidade); // estou passando a entidade que será salva, como é uma classe generica ele pode
									// pode-se assumir qualquer entidade
			transacao.commit(); // comfirma a tranção
		} catch (RuntimeException e) { // hibernate usa execoes de tempo de execuçoes
			if (transacao != null) {
				transacao.rollback(); // aqui ele verifica se existe um transção iniciada, como está no cacth
										// siginifica que algo de errado aconteceu, em seguida faco o rollback
			}
			throw e; // propaga o erro para outras camadas da aplicação
		} finally {
			sessao.close(); // fecho a sessão
		}
	}

	public void excluir(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe); // Criteria vem do hibernate para manipulação do banco
																// sem o uso direto do SQL
			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public Entidade buscarPorCodigo(int id) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(id)); // restriction tem a mesma fun��o do where em SQL
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

	public void editar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
	// neste metodo abaixo estou exemplificando como � utilizado o SQL nativo

	public void execultaQuery(String querySql) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			Query query = sessao.createSQLQuery(querySql);
			query.executeUpdate();
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			System.out.println("Erro ao executar SQL nativo ");
			throw erro;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listarSQL() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {

			Query query = sessao.createSQLQuery("SELECT * from aluno");
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List<Entidade> resultado = query.list();

			return resultado;
		} catch (RuntimeException erro) {
			System.out.println("Erro ao executar SQL nativo ");
			throw erro;
		} finally {
			sessao.close();
		}
	}

}
