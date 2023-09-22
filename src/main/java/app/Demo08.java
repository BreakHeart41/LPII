package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Producto;
import model.Usuario;

//GUI
public class Demo08 {
//	Listado de TODOS los USUARIOS, según un criterio (filtro)
	public static void main(String[] args) {
		
		String usuario = JOptionPane.showInputDialog("Ingrese usuario");
		String clave = JOptionPane.showInputDialog("Ingrese clave");
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");	
		EntityManager em = fabrica.createEntityManager();
		
//		Select * from tb_productos WHERE idtipo = ? --> LISTA		
		String jpsql = "Select u from Usuario u where u.usr_usua = :xusr and u.cla_usua = :xcla";
		try {
			Usuario u = em.createQuery(jpsql, Usuario.class)
									.setParameter("xusr", usuario)
									.setParameter("xcla", clave).getSingleResult();
			
//			Mostrar el contenido del usuario		
			JOptionPane.showMessageDialog(null,"Bienvenido: " + u.getNom_usua());
			FrmManteProd v = new FrmManteProd();
			v.setVisible(true);
//			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error: Usuario o clave incorrecto");
		}
		
				
		em.close();
	
	}

}
