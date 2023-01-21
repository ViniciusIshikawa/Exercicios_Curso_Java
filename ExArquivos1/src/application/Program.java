package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.entities.Produto;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);		
		String strPath = "D:\\DESENV\\anotacoes\\itensVendidos.csv";
		File path = new File(strPath);
		List<Produto> produtos = new ArrayList<>();
		
		try(BufferedReader bf = new BufferedReader(new FileReader(strPath))) {
			String line = bf.readLine();
			
			while(line != null) {
				String[] vetProduto = line.split(",");
				Produto produto = new Produto(vetProduto[0], Double.parseDouble(vetProduto[1]), Integer.parseInt(vetProduto[2]));
				produtos.add(produto);
				line = bf.readLine();
			}
			
		} 
		catch(IOException e ) {
			e.printStackTrace();
		}
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path.getParent() + "\\summary.txt"))) {
			for(Produto produto : produtos) {
				bw.write(produto.toString());
				bw.newLine();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
