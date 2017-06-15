package pe.joedayz.ejemplos.cinedayz.registro;

import pe.joedayz.ejemplos.cinedayz.dominio.Cliente;
import pe.joedayz.ejemplos.cinedayz.dominio.Usuario;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.ClienteDAO;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.UsuarioDAO;


public class ClienteService {
	ClienteDAO clienteDAO;
	UsuarioDAO usuarioDAO;
	
	
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public void registrar(Cliente cliente) throws Exception
	{
		crearCodigoCliente(cliente); 
		Cliente clienteEncontrado= clienteDAO.obtener(cliente.getCodigo());
		if (clienteEncontrado != null)
			throw new Exception("El cliente " + cliente.getCodigo() + "Ya existe");
		
		clienteDAO.crear(cliente);
		
	}
	
	public Cliente crearCodigoCliente(Cliente cliente)
	{
		String nombre= cliente.getNombre();
		String apellido1=cliente.getApellido1();
		String apellido2=cliente.getApellido2();
		
		String codigo = (nombre.substring(0, 1)).toLowerCase()+ apellido1.toLowerCase();
		  		
		if (codigo.length() < 9){			
			codigo = nombre.substring(0, 1)+((apellido1 + apellido2).substring(0, 9)).toLowerCase();
		    cliente.setCodigo(codigo);
		    cliente.setClave(codigo);
		}else{ cliente.setCodigo(codigo);
			   cliente.setClave(codigo);
		}
			
		return cliente;
	}
	
	public Cliente autenticar(Cliente cliente) throws Exception
	{
		Cliente clienteEncontrado = clienteDAO.obtener(cliente.getCodigo());
		if (clienteEncontrado == null)throw new Exception("El cliente " + cliente.getCodigo() + "No existe");
		
		if (cliente.getClave().equals(clienteEncontrado.getClave())   )
	    {
			
	    	System.out.println("Cliente "+ clienteEncontrado.getNombre() +" puede empezar a usar el sistema");
	    	
	    }else
	    {	    	
	    	clienteEncontrado.setIntentos(clienteEncontrado.getIntentos()+1);
	    	if (clienteEncontrado.getIntentos() > 3)
	    		clienteEncontrado.setStatus("B");
	    	clienteDAO.modificar(clienteEncontrado);
	    	System.out.println("Clave diferente. Intentos: "+clienteEncontrado.getIntentos());
	    }
		return clienteEncontrado;
				
	}
	
	public Usuario autenticarAdmin(String usuario,String clave) 
	{	
	//	Usuario usuarioEncontrado= new Usuario();
		//Usuario usuarioTemp = usuarioDAO.obtener(usuario);
		
		Usuario usuarioEncontrado = usuarioDAO.obtener(usuario);
		if (usuarioEncontrado ==null) return null;
		//assertNotNull(usuarioTemp );
		System.out.println("usuario->"+usuarioEncontrado.getPosition());
		   if (usuarioEncontrado.getPosition().equals("admin")){
			   if (usuarioEncontrado.getClave().equals(clave)){
				  	return usuarioEncontrado;	     
		   }			   
		   }
	   return null;
	}
	
	public Cliente autenticarCliente(String clicodigo,String clave) 
	{	
	//	Usuario usuarioEncontrado= new Usuario();
		//Usuario usuarioTemp = usuarioDAO.obtener(usuario);
		
		Cliente clienteEncontrado = clienteDAO.obtener(clicodigo);
		if (clienteEncontrado ==null) return null;
		//assertNotNull(usuarioTemp );
		System.out.println("usuario->"+clienteEncontrado.getEmail());
		
		if (clienteEncontrado.getClave().equals(clave)){
			return clienteEncontrado;	     
		}			   
		   
	   return null;
	}   
	
	
}
