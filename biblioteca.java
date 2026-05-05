import java.util.*;

abstract class MaterialBiblioteca {
    static int contador = 1;

    int id;
    String titulo;
    String autor;
    int anio;
    boolean leido;

    MaterialBiblioteca(String t, String a, int an) {
        id = contador++;
        titulo = t;
        autor = a;
        anio = an;
        leido = false;
    }

    void marcarLeido() { leido = true; }
    boolean estaLeido() { return leido; }

    abstract String getResumen(); // polimorfismo
}

class Libro extends MaterialBiblioteca {
    int paginas;
    String genero;

    Libro(String t, String a, int an, int p, String g) {
        super(t, a, an);
        paginas = p;
        genero = g;
    }

    String getResumen() {
        return "Libro: " + titulo + " (" + genero + ", " + paginas + " pags)";
    }
}

class Revista extends MaterialBiblioteca {
    int edicion;
    String tematica;

    Revista(String t, String a, int an, int e, String tem) {
        super(t, a, an);
        edicion = e;
        tematica = tem;
    }

    String getResumen() {
        return "Revista: " + titulo + " (Ed " + edicion + ")";
    }
}

class Audiolibro extends MaterialBiblioteca {
    int duracion;
    String narrador;

    Audiolibro(String t, String a, int an, int d, String n) {
        super(t, a, an);
        duracion = d;
        narrador = n;
    }

    String getResumen() {
        return "Audio: " + titulo + " (" + duracion + " min)";
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<MaterialBiblioteca> lista = new ArrayList<>();

    public static void main(String[] args) {

        int op;

        do {
            System.out.println("1.Libro");
            System.out.println("2.Revista");
            System.out.println("3.Audio");
            System.out.println("4.Listar");
            System.out.println("5.Buscar");
            System.out.println("6.Leido");
            System.out.println("0.Salir");
            op = Integer.parseInt(sc.nextLine());

            switch (op) {

                case 1:
                    System.out.print("Titulo: "); String t1 = sc.nextLine();
                    System.out.print("Autor: "); String a1 = sc.nextLine();
                    System.out.print("Año: "); int an1 = Integer.parseInt(sc.nextLine());
                    System.out.print("Paginas: "); int p = Integer.parseInt(sc.nextLine());
                    System.out.print("Genero: "); String g = sc.nextLine();
                    lista.add(new Libro(t1, a1, an1, p, g));
                    break;

                case 2:
                    System.out.print("Titulo: "); String t2 = sc.nextLine();
                    System.out.print("Autor: "); String a2 = sc.nextLine();
                    System.out.print("Año: "); int an2 = Integer.parseInt(sc.nextLine());
                    System.out.print("Edicion: "); int e = Integer.parseInt(sc.nextLine());
                    System.out.print("Tematica: "); String tem = sc.nextLine();
                    lista.add(new Revista(t2, a2, an2, e, tem));
                    break;

                case 3:
                    System.out.print("Titulo: "); String t3 = sc.nextLine();
                    System.out.print("Autor: "); String a3 = sc.nextLine();
                    System.out.print("Año: "); int an3 = Integer.parseInt(sc.nextLine());
                    System.out.print("Duracion: "); int d = Integer.parseInt(sc.nextLine());
                    System.out.print("Narrador: "); String n = sc.nextLine();
                    lista.add(new Audiolibro(t3, a3, an3, d, n));
                    break;

                case 4:
                    for (MaterialBiblioteca m : lista) {
                        System.out.println(m.id + " - " + m.getResumen() + " | Leido: " + m.leido);
                    }
                    break;

                case 5:
                    System.out.print("Buscar: ");
                    String txt = sc.nextLine().toLowerCase();
                    for (MaterialBiblioteca m : lista) {
                        if (m.titulo.toLowerCase().contains(txt) ||
                            m.autor.toLowerCase().contains(txt)) {
                            System.out.println(m.getResumen());
                        }
                    }
                    break;

                case 6:
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    for (MaterialBiblioteca m : lista) {
                        if (m.id == id) {
                            m.marcarLeido();
                            System.out.println("Marcado como leido");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (op != 0);
    }
}
