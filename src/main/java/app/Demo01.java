package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

//GUI
public class Demo01 {
	//Realizar el registro de un nuevo User usando valores fijos
	public static void main(String[] args) {
		//1.Obtener Connecction -> Llamar a la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
	
		//2. Crear un manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//Procesos
		Usuario u = new Usuario();
		u.setCod_usua(123);
		u.setNom_usua("Juan");
		u.setApe_usua("Perez");
		u.setUsr_usua("jperez");
		u.setCla_usua("7854");
		u.setFna_usua("2000/01/15");
		u.setIdtipo(1);
		u.setEst_usua(1);
		
//		Usuario u = new Usuario(321,"Maria","López","mlopez","marial","2005/05/25",1,1);
		//Insert into tb_xxx values(?,?....)
		//Si el proceso es: reg/act/elim -> necesitan _ trasacciones
		em.getTransaction().begin();
		em.persist(u);
		//UPDATE tb_xxx set campo = ?... WHERE ...
		em.merge(u);
		//DELETE from tb_xxx where
		em.remove(u);
		//SELECT * FROM tb_xxx where id = ?
		Usuario x = em.find(Usuario.class, 1);
		em.getTransaction().commit();
		System.out.println("Registro OK");
		em.close();
	
	}

}
