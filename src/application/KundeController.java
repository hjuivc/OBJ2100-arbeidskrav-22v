package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class KundeController {
	DatabaseKontroll kontroll = new DatabaseKontroll();
	private ObservableList<Kino> data = FXCollections.observableArrayList();
	
	@FXML
	private Label overskrift;
	
	@FXML
	private SplitMenuButton valg;
	
	@FXML
	private Button book;
	
	@FXML
	private TableView<Kino> tabell;
	
	@FXML
	private Button last;
	
	@FXML
	private Button tilbake;
	
	@FXML
	private Button lastvalgtdato;
	
	@FXML
	private Button lastvalgtfilm;
	
	@FXML
	private DatePicker datovelger;
	
	@FXML
	private DatePicker datoValgt;
	
	@FXML
	private LocalDate dato;
	
	@FXML
	private TableColumn<Kino, Integer> colkinosal;
	
	@FXML
	private TableColumn<Kino, Date> coldato;
	
	@FXML
	private TableColumn<Kino, Time> coltidspunkt;
	
	@FXML
	private TableColumn<Kino, Double> colpris;
	
	@FXML
	private TableColumn<Kino, String> colfilm;
	
	public KundeController() {
	}
	
	// Instansiering
	@FXML
	public void Initialize() {
			
	}
	
	@FXML
	public void tilbakeKunde(ActionEvent e) throws IOException {
		Parent kundeParent = FXMLLoader.load(getClass().getResource("scene1.fxml"));
		Scene scene1 = new Scene(kundeParent);
		Stage kundevindu = (Stage) ((Node)e.getSource()).getScene().getWindow();
		kundevindu.setScene(scene1);
		kundevindu.show();
	}
	
	public ObservableList<Kino> hentInnhold() throws Exception {
		ObservableList<Kino> data = FXCollections.observableArrayList();
		kontroll.lagForbindelse();
		String sql = "SELECT tblvisning.v_kinosalnr, tblvisning.v_dato, tblvisning.v_starttid, tblvisning.v_pris, tblfilm.f_filmnavn FROM tblvisning, tblfilm WHERE tblvisning.v_filmnr = tblfilm.f_filmnr ORDER BY tblvisning.v_dato ASC, tblvisning.v_starttid ASC";
		Statement utsagn;
        ResultSet resultat;
        
		try {
			utsagn = kontroll.forbindelse.createStatement();
			resultat = utsagn.executeQuery(sql);
			Kino kino;
			while(resultat.next()) {
				kino = new Kino(resultat.getInt("v_kinosalnr"), resultat.getDate("v_dato"), resultat.getTime("v_starttid"), resultat.getDouble("v_pris"), resultat.getString("f_filmnavn"));
                data.add(kino);
                }
		} catch (SQLException e) {System.out.println(e);}  
		return data;
		
	}
	
	@FXML
	public void brukInnhold(ActionEvent e) throws Exception{
		ObservableList<Kino> list = hentInnhold();
		colkinosal.setCellValueFactory(new PropertyValueFactory<Kino, Integer>("Kinosalnr"));
		coldato.setCellValueFactory(new PropertyValueFactory<Kino, Date>("Dato"));
		coltidspunkt.setCellValueFactory(new PropertyValueFactory<Kino, Time>("Starttid"));
		colpris.setCellValueFactory(new PropertyValueFactory<Kino, Double>("Pris"));
		colfilm.setCellValueFactory(new PropertyValueFactory<Kino, String>("Film"));
		tabell.setItems(list);
	}
	
	public ObservableList<Kino> hentInnholdDato() throws Exception {
		ObservableList<Kino> data = FXCollections.observableArrayList();
		kontroll.lagForbindelse();
		dato = datoValgt.getValue();
		String sql = "SELECT tblvisning.v_kinosalnr, tblvisning.v_dato, tblvisning.v_starttid, tblvisning.v_pris, tblfilm.f_filmnavn FROM tblvisning, tblfilm WHERE tblvisning.v_filmnr = tblfilm.f_filmnr AND tblvisning.v_dato = '"+ dato +"' ORDER BY tblvisning.v_dato ASC, tblvisning.v_starttid ASC";
		Statement utsagn;
        ResultSet resultat;
		try {
			utsagn = kontroll.forbindelse.createStatement();
			resultat = utsagn.executeQuery(sql);
			Kino kino;
			while(resultat.next()) {
				kino = new Kino(resultat.getInt("v_kinosalnr"), resultat.getDate("v_dato"), resultat.getTime("v_starttid"), resultat.getDouble("v_pris"), resultat.getString("f_filmnavn"));
                data.add(kino);
                }
		} catch (SQLException e2) {System.out.println(e2);}
		return data;
		
	}
	
	        
	
	@FXML
	public void brukInnholdDato(ActionEvent e) throws Exception{
		ObservableList<Kino> list = hentInnholdDato();
		colkinosal.setCellValueFactory(new PropertyValueFactory<Kino, Integer>("Kinosalnr"));
		coldato.setCellValueFactory(new PropertyValueFactory<Kino, Date>("Dato"));
		coltidspunkt.setCellValueFactory(new PropertyValueFactory<Kino, Time>("Starttid"));
		colpris.setCellValueFactory(new PropertyValueFactory<Kino, Double>("Pris"));
		colfilm.setCellValueFactory(new PropertyValueFactory<Kino, String>("Film"));
		tabell.setItems(list);
	}
	
	@FXML
	public SplitMenuButton setMenyKnapp() throws Exception {
		kontroll.lagForbindelse();
		String sql = "SELECT f_filmnavn FROM tblfilm";
		Statement utsagn = kontroll.forbindelse.createStatement();
		ResultSet resultat = utsagn.executeQuery(sql);
		try {
	        while(resultat.next()) {
	            String name = resultat.getString("f_filmnavn");
	            MenuItem menuItem = new MenuItem(name);
	            // add event handlers, etc, as needed..
	            valg.getItems().add(menuItem);
	        }
	    } catch (SQLException e3) {System.out.println(e3);}
		return valg;
	}

	public ObservableList<Kino> hentInnholdFilm() throws Exception {
		ObservableList<Kino> data = FXCollections.observableArrayList();
		kontroll.lagForbindelse();
		SplitMenuButton film = setMenyKnapp();
		System.out.println(valg);
		String sql = "SELECT tblvisning.v_kinosalnr, tblvisning.v_dato, tblvisning.v_starttid, tblvisning.v_pris, tblfilm.f_filmnavn FROM tblvisning, tblfilm WHERE tblvisning.v_filmnr = tblfilm.f_filmnr AND tblvisning.f_filmnavn = '"+ film +"' ORDER BY tblvisning.v_dato ASC, tblvisning.v_starttid ASC";
		Statement utsagn;
        ResultSet resultat;
		try {
			utsagn = kontroll.forbindelse.createStatement();
			resultat = utsagn.executeQuery(sql);
			Kino kino;
			while(resultat.next()) {
				kino = new Kino(resultat.getInt("v_kinosalnr"), resultat.getDate("v_dato"), resultat.getTime("v_starttid"), resultat.getDouble("v_pris"), resultat.getString("f_filmnavn"));
                data.add(kino);
                }
		} catch (SQLException e2) {System.out.println(e2);}
		return data;
		
	}
	
	        
	
	@FXML
	public void brukInnholdFilm(ActionEvent e) throws Exception{
		ObservableList<Kino> list = hentInnholdFilm();
		colkinosal.setCellValueFactory(new PropertyValueFactory<Kino, Integer>("Kinosalnr"));
		coldato.setCellValueFactory(new PropertyValueFactory<Kino, Date>("Dato"));
		coltidspunkt.setCellValueFactory(new PropertyValueFactory<Kino, Time>("Starttid"));
		colpris.setCellValueFactory(new PropertyValueFactory<Kino, Double>("Pris"));
		colfilm.setCellValueFactory(new PropertyValueFactory<Kino, String>("Film"));
		tabell.setItems(list);
	
	
	}
}