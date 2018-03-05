package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.Usuario;
import util.HibernateUtil;

public class UsuarioDAO {

	@SuppressWarnings("unchecked")
	public List<Usuario> listarSQL() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {

			Query query = sessao.createSQLQuery("SELECT * from usuario");
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List<Usuario> resultado = query.list();

			return resultado;
		} catch (RuntimeException erro) {
			System.out.println("Erro ao executar SQL nativo ");
			throw erro;
		} finally {
			sessao.close();
		}
	}

}
