package br.imd.control;

import java.awt.Desktop;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.imd.modelo.Scrapper;
import br.imd.modelo.Compare.CompareCosine;
import br.imd.modelo.Compare.CompareJaro;
import br.imd.modelo.Texto.TextoComparar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import javafx.scene.control.TextArea;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class Controller implements Initializable {
	@FXML
	private TextArea taText;
	@FXML
	private Button scrapButton;
	@FXML
	private Button compareButton;
	@FXML
	private Button openButton;
	@FXML
	private Slider thresholdSlide;
	@FXML
	private Label myLabel;
	@FXML
	private ChoiceBox<String> compareSlide;
	
	private TextoComparar textoComparar = new TextoComparar();
	

	
	public TextArea getTaText() {
		return taText;
	}
	public void setTaText(TextArea taText) {
		this.taText = taText;
	}
	public Button getScrapButton() {
		return scrapButton;
	}
	public void setScrapButton(Button scrapButton) {
		this.scrapButton = scrapButton;
	}
	public Button getCompareButton() {
		return compareButton;
	}
	public void setCompareButton(Button compareButton) {
		this.compareButton = compareButton;
	}
	public Button getOpenButton() {
		return openButton;
	}
	public void setOpenButton(Button openButton) {
		this.openButton = openButton;
	}
	public Slider getThresholdSlide() {
		return thresholdSlide;
	}
	public void setThresholdSlide(Slider thresholdSlide) {
		this.thresholdSlide = thresholdSlide;
	}
	public Label getMyLabel() {
		return myLabel;
	}
	public void setMyLabel(Label myLabel) {
		this.myLabel = myLabel;
	}
	public ChoiceBox<String> getCompareSlide() {
		return compareSlide;
	}
	public void setCompareSlide(ChoiceBox<String> compareSlide) {
		this.compareSlide = compareSlide;
	}
	public TextoComparar getTextoComparar() {
		return textoComparar;
	}
	public void setTextoComparar(TextoComparar textoComparar) {
		this.textoComparar = textoComparar;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		String[] compares = {"Jaro", "Cosine"};
		compareSlide.getItems().addAll(compares);
	
		Leitura arquivo = new Leitura();
		arquivo.Organizar("boatos.csv");
		
	}
	@FXML
	private void handleScrapAction(ActionEvent Event) throws Exception {
		Scrapper leitor = new Scrapper();
		String str;
		str = Normalizer.normalize(leitor.scrap(), Normalizer.Form.NFD);
				
		taText.setText(str);
		
		taText.setWrapText(true);
	}
	@FXML
	private void handleOpenAction(ActionEvent Event) throws Exception {
		String inputFile = "boatos.csv";
	    Path tempOutput = Files.createTempFile("FakeNews", ".csv");
	    tempOutput.toFile().deleteOnExit();
	    System.out.println("tempOutput: " + tempOutput);
	    try (InputStream is = getClass().getClassLoader().getResourceAsStream(inputFile)){
	        Files.copy(is, tempOutput, StandardCopyOption.REPLACE_EXISTING);
	    }
	    Desktop.getDesktop().open(tempOutput.toFile());
	}
	@FXML
	private void handleCompareAction(ActionEvent Event) throws Exception{
		if(compareSlide.getValue() == "Jaro") {
			//INICIAR A DAO E PEGAR A LISTA DE TEXTOS FAKES AQUI
			CompareJaro j = new CompareJaro();
			double d = thresholdSlide.getValue();
			j.setThreshold(d);
			String t = taText.getText();
			textoComparar.setOriginalText(t);
			try {
				textoComparar.Process();
			}catch(Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Alerta de Erro");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
			
			ArrayList<String> f = new ArrayList<String>();
			f = textoComparar.getProcessText();
			
			
			if(j.Compare(f)) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Comparação bem sucedida!");
				alert.setContentText("Seu texto é fake!");
				alert.showAndWait();
			}else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Comparação bem sucedida!");
				alert.setContentText("Seu texto não é fake!");
				alert.showAndWait();
			}
			
		}else {
			if(compareSlide.getValue() == "Cosine") {
				//INICIAR O DAO E PEGAR A LISTA DE TEXTOS FAKES AQUI
				CompareCosine c = new CompareCosine();
				double d = thresholdSlide.getValue();
				c.setThreshold(d);
				String t = taText.getText();
				textoComparar.setOriginalText(t);
				try {
					textoComparar.Process();
				}catch(Exception e) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Alerta de Erro");
					alert.setContentText(e.getMessage());
					alert.showAndWait();
				}
				
				ArrayList<String> f = new ArrayList<String>();
				f = textoComparar.getProcessText();
				if(c.Compare(f)) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Comparação bem sucedida!");
					alert.setContentText("Seu texto é fake!");
					alert.showAndWait();
				}else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Comparação bem sucedida!");
					alert.setContentText("Seu texto não é fake!");
					alert.showAndWait();
				}
				
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Alerta de Erro");
				alert.setContentText("Por favor selecione um método de comparação");
				alert.showAndWait();
			}
		}
		
		
	}


}
