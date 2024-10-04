import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void main(String[] args) {
        Texto texto = new Texto();
        texto.copiarTexto();
        texto.leerTexto();
    }
}

class Texto {
    private String[] codes = {"p1", "p2", "p3"};
    private String[] descricion = {"parafusos", "cravos", "tachas"};
    private int[] prices = {3, 4, 5};

    public void copiarTexto() {
        try (
                RandomAccessFile raf = new RandomAccessFile("texto1.txt", "rw");
        ){
            for (int i=0; i<3; i++){
                raf.writeChars(String.format("%" + 3 + "s", codes[i]));
                raf.writeChars(String.format("%" + 10 + "s", descricion[i]));
                raf.writeInt(prices[i]);
            }
        } catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void leerTexto() {
        try(
               RandomAccessFile raf = new RandomAccessFile("texto1.txt", "rw")
        ){
            raf.seek(30);

            for (int i=0; i<3; i++){
                System.out.print(raf.readChar());
            }
            System.out.println();

            for (int i=0; i<10; i++){
                System.out.print(raf.readChar());
            }
            System.out.println();

            System.out.print(raf.readInt());

        } catch (EOFException e){
            System.out.println();
        } catch (IOException y){
            System.out.println("Error: "+y.getMessage());
        }
    }
}