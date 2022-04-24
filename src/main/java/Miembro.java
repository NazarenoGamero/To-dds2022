public class Miembro {
    private String nombre;
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public boolean esMiembro(Sector sector){
        return sector.perteneceA(this);
    }
    public static void main(String[] args){
        Miembro miembro1 = new Miembro();
        miembro1.setNombre("miembro1");
        Sector sector = new Sector();
        sector.agregarMiembro(miembro1);
        System.out.println(miembro1.esMiembro(sector));
    }
}
