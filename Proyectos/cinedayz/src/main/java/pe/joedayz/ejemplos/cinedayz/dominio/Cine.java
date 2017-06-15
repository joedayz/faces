package pe.joedayz.ejemplos.cinedayz.dominio;

public class Cine {
	String codigo;
	String nombre;
	String direccion;
	String distrito;
	String cineManager;
	
	
	public Cine(String strcodcine,String strnom, String strdir, String strdis)
	{
	   	codigo   = strcodcine;
		nombre   = strnom;
	   	direccion= strdir;
	   	distrito= strdis;
	
	}
	
	public static Cine creaCine(String codigo, String nombre, String direccion,String distrito ) {
		return new Cine(codigo,nombre, direccion, distrito);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCineManager() {
		return cineManager;
	}

	public void setCineManager(String cineManager) {
		this.cineManager = cineManager;
	}

	
	public String getDireccion() {
		return direccion;
	}

	public String getDistrito() {
		return distrito;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNombreCine(String strNom)
	{
		nombre =strNom;
	}
	public String getCineNombre()
	{
		return nombre;
	}
	
	public void setDireccion(String strDireccion)
	{
		direccion =strDireccion;
	}
	public String getCineDireccion()
	{
		return direccion;
	}
	
	public void setDistrito(String strDistrito)
	{
		distrito =strDistrito;
	}
	
	public String getDistritoCine()
	{
		return distrito;
	}

		
	
	
}
