package dds.grupo3.clases.organizacion;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TipoOrg {
	@Column(name = "TIPO")
	private String tipo;

  public TipoOrg(String nombre) {
    this.tipo = nombre;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }


}
