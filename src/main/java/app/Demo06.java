package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;
import model.Usuario;

//GUI
public class Demo06 {
//	Listado de TODOS los USUARIOS, mostrand nombre del proveedor y nombre de categoria 
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");	
		EntityManager em = fabrica.createEntityManager();
		
//		Select * from tb_productos --> LISTA
		
		String jpsql = "Select p from Producto p";
		List<Producto> lstProductos = em.createQuery(jpsql, Producto.class).getResultList();
		
//		Mostrar el contenido del listado
		for (Producto p : lstProductos) {
			System.out.println("Codigo......: " + p.getId_prod());
			System.out.println("Nombre......: " + p.getDes_prod());
			System.out.println("Categoria......: " + p.getObjCategoria().getDescripcion());
			System.out.println("Proveedor......: " + p.getObjProveedor().getNombre_rs());
			System.out.println("----------------------------");
		}
				
		em.close();
	
	}

}
