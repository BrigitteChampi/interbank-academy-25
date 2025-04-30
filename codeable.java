import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Error;

public class codeable{
    public static void main(String [] args){
        
        //Ruta del archivo csv, ubicacion de la data
        String data = "C:/Users/arely/Documents/GitHub/interbank-academy-25/data.csv";
      

        /******************* VARIABLES *******************/
        int credito = 0; // cantidad de transacciones de credito
        int debito = 0; // cantidad de transacciones de debito
        int numTransacciones = 0; // total de transacciones

        double balanceFinal = 0.0; //creditos + debitos
        double montoMaximo = 0.0; // monto mas alto
        
        String transID = " "; // ID de la transaccion mas alta

        try{
            //lectura del archivo data
            Scanner sc = new Scanner(new File(data));
            boolean encabezado = true; 

            while (sc.hasNextLine()) {
                String valores = sc.nextLine(); // lectura del archivo, linea por linea

                //Omite los emcabezados
                if(encabezado){
                    encabezado = false;
                    continue;
                }

                //Separar valores por comas
                String [] dataPartes = valores.split(",");

                if(dataPartes.length !=3) continue; // Verifica que el string contenga las 3 partes: ID-TIPO-MONTO
                /************ DIVISION EN SUB ARRAY ***************/

                String id = dataPartes [0];
                String tipo = dataPartes [1];
                double monto = Double.parseDouble(dataPartes[2]);

                //Balance
                if(tipo.equalsIgnoreCase("Crédito")){                   
                    balanceFinal+= monto;   
                    credito++;
                    numTransacciones++;
                }else{
                    if (tipo.equalsIgnoreCase("Débito")) {
                        balanceFinal-= monto;
                        debito++; 
                        numTransacciones++;               
                    }
                }

                //Buscar transaccion mas alta
                if(monto > montoMaximo){
                    montoMaximo = monto;
                    transID = id;
                }
            }
            // Mostrar el reporte
            System.out.println("Reporte de Transacciones");
            System.out.println("---------------------------------------------");
            System.out.printf("Balance Final: %.2f %n" , balanceFinal);
            System.out.printf("Transacción Mayor: %n ID: %s  -  MONTO: %.2f %n" , transID, montoMaximo);            
            System.out.println("Conteo total de Transacciones: " + numTransacciones);
            System.out.printf("Transacciones de Crédito: %d - Transacciones de Débito: %d\n", credito, debito);

            sc.close();
        }catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo " + data);
        }
    }
}
