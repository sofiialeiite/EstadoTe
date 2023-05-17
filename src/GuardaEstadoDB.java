package src;

import java.io.*;


public class GuardaEstadoDB implements Serializable{
    private static final long serialVersionUID = 1L;

    public void guardaEstadoDB (String caminhoFicheiro, DataBase database) throws FileNotFoundException, IOException {
        try {
            FileOutputStream file = new FileOutputStream(caminhoFicheiro);
            ObjectOutputStream oos = new ObjectOutputStream(file);

            oos.writeObject(database);

            oos.close();
            file.close();

            System.out.println("O estado do programa foi salvo com Sucesso");
        }

        catch (Exception e){
            System.out.println("Erro ao salvar o estado do programa.");
        }
    }

    public DataBase carregaEstadoDB (String caminhoFicheiro) throws FileNotFoundException, IOException{
        try {
            FileInputStream file = new FileInputStream(caminhoFicheiro);
            ObjectInputStream oos = new ObjectInputStream(file);

            Object objetoSalvo = oos.readObject();

            DataBase database_salva = (DataBase) objetoSalvo;

            oos.close();

            System.out.println("O estado do programa foi carregado com sucesso");

            return database_salva;
        } catch (Exception e) {
            System.out.println("Criando nova gravação do programa.");

            return new DataBase();
        }
    }
}
