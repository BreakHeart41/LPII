package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

//GUI
public class Demo05 {
//	Listado de TODOS los USUARIOS, mostrandp además el tipo de usuario
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");	
		EntityManager em = fabrica.createEntityManager();
		
//		Select * from tb_usuarios --> LISTA
		
		String jpsql = "Select u from Usuario u";
		List<Usuario> lstUsuarios = em.createQuery(jpsql, Usuario.class).getResultList();
		
//		Mostrar el contenido del listado
		for (Usuario u : lstUsuarios) {
			System.out.println("Codigo......: " + u.getCod_usua());
			System.out.println("Nombre......: " + u.getNom_usua());
			System.out.println("Tipo......: " + u.getIdtipo() + " - " + u.getObjTipo().getDescripcion());
			System.out.println("----------------------------");
		}
				
		em.close();
	
	}

}
