package dds.grupo3.clases.organizacion;

public enum Clasificacion {
	MINISTERIO("MINISTERIO"),
	UNIVERSIDAD("UNIVERSIDAD"),
	ESCUELA("ESCUELA"),
	EMPRESASECTORPRIMARIO("EMPRESASECTORPRIMARIO"),
	EMPRESASECTORSECUNDARIO("EMPRESASECTORSECUNDARIO");

	public final String label;

	private Clasificacion(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
/*
	@Override
	public String toString(){
		return label;
	}
*/
}
