import java.util.List;

public class Sector {
    private String nombre;
    private List<Miembro> miembros;
    public void agregarMiembro(Miembro miembro) {
        miembros.add(miembro);
    }
    public boolean perteneceA(Miembro miembro) {
        return miembros.contains(miembro);
    }
}