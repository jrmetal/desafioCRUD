package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	
	private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes(); // recebe o retorno do metodo 

	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}

	private static SessionFactory criarFabricaDeSessoes() {
		try {
			Configuration configuracao = new Configuration().configure();  // busca e lê  as configurações do hibernate.cfg.xml

			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build(); // registra o servico do hibenrate 

			SessionFactory fab = configuracao.buildSessionFactory(registro); // constroi a fabrica de sessoes 

			return fab;
		} catch (Throwable ex) {
			System.err.println("A fábrica de sessões não pode ser criada." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

}
	
	
	

