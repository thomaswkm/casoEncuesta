import java.util.Random;
import java.util.Scanner;

public class encuesta {
    public static void main(String[] args) {

        char[][] votos = new char[2][obtenerColumnas()];
        menu(votos);

    }

    public static void menu(char[][] votos){

        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Llenar con votos el arreglo");
        System.out.println("2. Mostrar cuantos hombres aprueban la gestión del gobierno");
        System.out.println("3. Mostrar cuantas mujeres desaprueban la gestión del gobierno");
        System.out.println("4. Mostrar qué porcentaje del total de encuestados aprueba la gestión del gobierno");
        System.out.println("5. Mostrar cuantas personas participaron en la encuesta");
        System.out.println("6. Salir");
        int ans = sc.nextInt();
        respuesta(votos, ans);
        menu(votos);
    }

    public static void respuesta(char[][] votos,int ans){

        switch (ans){
            case 1 -> {
                llenarArreglo(votos);
                imprimir(votos);
            }
            case 2 -> System.out.println(calcularVotos(votos,0,'s')+" hombres aprueban la gestión del gobierno");
            case 3 -> System.out.println(calcularVotos(votos,1,'n')+" mujeres desaprueban la gestión del gobierno");
            case 4 -> System.out.println("Aprueban la gestion en un  total de: "+calcularPorcentaje(votos)+"%");
            case 5 -> System.out.println("Participaron un total de: "+votos[0].length*2+" personas");
            case 6 -> System.exit(0);

        }
    }

    public static int obtenerColumnas(){

        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas parejas de votantes deseas?");
        return sc.nextInt();
    }

    public static void llenarArreglo(char[][] votos){
        Random rd = new Random();
        for (int i = 0; i < votos.length; i++) {
            for (int j = 0; j < votos[i].length; j++) {
                int random = rd.nextInt(3);
                switch (random) {
                    case 0 -> votos[i][j] = 's';
                    case 1 -> votos[i][j] = 'n';
                    case 2 -> votos[i][j] = 'x';
                }
            }
        }
    }

    public static void imprimir(char[][] votos){
        for (int i = 0; i < votos.length; i++) {
            for (int j = 0; j < votos[i].length; j++) {
                System.out.print("["+votos[i][j]+"]");
            }
            System.out.println();
        }
    }

    public static int calcularVotos(char[][] votos, int fila, char opcion){
        int cant = 0;
        for (int i = 0; i < votos[fila].length; i++) {
            if(votos[fila][i]==opcion){
                cant += 1;
            }
        }
        return cant;
    }

    public static double calcularPorcentaje(char[][] votos){
        double cantidadApruebos = calcularVotos(votos,0,'s')+calcularVotos(votos,1,'s');

        return cantidadApruebos*100/(votos[0].length*2);
    }


}
