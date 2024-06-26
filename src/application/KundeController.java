package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class KundeController {
	DatabaseKontroll kontroll = new DatabaseKontroll();
	private ObservableList<Kino> data = FXCollections.observableArrayList();
	
	@FXML
	private Label overskrift;
	
	@FXML
	private ChoiceBox<String> valg;
	
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
	
	@FXML
	private TextField bookFilm;
	
	@FXML
	private TextField bookDato;
	
	@FXML
	private TextField bookTidspunkt;
	
	@FXML
	private TextField bookKinosal;
	
	@FXML
	private TextField bookAntall;
	
	@FXML
	private TextField bookPris;
	
	@FXML
	private Label bookText;
	
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
		String sql = "SELECT tblvisning.v_kinosalnr, tblvisning.v_dato, tblvisning.v_starttid, tblvisning.v_pris, tblfilm.f_filmnavn, tblvisning.v_visningnr FROM tblvisning, tblfilm WHERE tblvisning.v_filmnr = tblfilm.f_filmnr ORDER BY tblvisning.v_dato ASC, tblvisning.v_starttid ASC";
		Statement utsagn;
        ResultSet resultat;
        
		try {
			utsagn = kontroll.forbindelse.createStatement();
			resultat = utsagn.executeQuery(sql);
			Kino kino;
			while(resultat.next()) {
				kino = new Kino(resultat.getInt("v_kinosalnr"), resultat.getDate("v_dato"), resultat.getTime("v_starttid"), resultat.getDouble("v_pris"), resultat.getString("f_filmnavn"), resultat.getInt("v_visningnr"));
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
		String sql = "SELECT tblvisning.v_kinosalnr, tblvisning.v_dato, tblvisning.v_starttid, tblvisning.v_pris, tblfilm.f_filmnavn, tblvisning.v_visningnr FROM tblvisning, tblfilm WHERE tblvisning.v_filmnr = tblfilm.f_filmnr AND tblvisning.v_dato = '"+ dato +"' ORDER BY tblvisning.v_dato ASC, tblvisning.v_starttid ASC";
		Statement utsagn;
        ResultSet resultat;
		try {
			utsagn = kontroll.forbindelse.createStatement();
			resultat = utsagn.executeQuery(sql);
			Kino kino;
			while(resultat.next()) {
				kino = new Kino(resultat.getInt("v_kinosalnr"), resultat.getDate("v_dato"), resultat.getTime("v_starttid"), resultat.getDouble("v_pris"), resultat.getString("f_filmnavn"), resultat.getInt("v_visningnr"));
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
	

	public ObservableList<Kino> hentInnholdFilm() throws Exception {
		ObservableList<Kino> data = FXCollections.observableArrayList();
		kontroll.lagForbindelse();
		String film = valg.getValue();
		String sql = "SELECT tblvisning.v_kinosalnr, tblvisning.v_dato, tblvisning.v_starttid, tblvisning.v_pris, tblfilm.f_filmnavn, tblvisning.v_visningnr FROM tblvisning, tblfilm WHERE tblvisning.v_filmnr = tblfilm.f_filmnr AND tblfilm.f_filmnavn = '"+ film +"' ORDER BY tblvisning.v_dato ASC, tblvisning.v_starttid ASC";
		Statement utsagn;
        ResultSet resultat;
		try {
			utsagn = kontroll.forbindelse.createStatement();
			resultat = utsagn.executeQuery(sql);
			Kino kino;
			while(resultat.next()) {
				kino = new Kino(resultat.getInt("v_kinosalnr"), resultat.getDate("v_dato"), resultat.getTime("v_starttid"), resultat.getDouble("v_pris"), resultat.getString("f_filmnavn"), resultat.getInt("v_visningnr"));
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
	
	public void oppsettFilm() throws Exception{
		kontroll.lagForbindelse();
		String sql = "SELECT f_filmnavn FROM tblfilm";
		Statement utsagn = kontroll.forbindelse.createStatement();
		ResultSet resultat = utsagn.executeQuery(sql);
		try {
	        while(resultat.next()) {
	            String name = resultat.getString("f_filmnavn");
	            // add event handlers, etc, as needed..
	            valg.getItems().add(name);
	        }
	    } catch (SQLException e3) {System.out.println(e3);}
	}

	@FXML
	public void test(MouseEvent e) throws Exception{
		Kino listSelected = tabell.getSelectionModel().getSelectedItem();
		bookFilm.setText(listSelected.getFilm());
		bookDato.setText(listSelected.getDato().toString());
		bookTidspunkt.setText(listSelected.getStarttid().toString());
		bookKinosal.setText(""+listSelected.getKinosalnr());


	}
	
	@FXML
	public final EventHandler<ActionEvent> kalkulerPris() throws Exception {
		Kino listSelected = tabell.getSelectionModel().getSelectedItem();
		int antall=Integer.parseInt(bookAntall.getText());  
		bookPris.setText(""+(listSelected.getPris()*antall));

		
		return null;
	}
	
	@FXML
	public void bookBilletter(ActionEvent e) throws Exception {
		kontroll.lagForbindelse();
		
		char[] bokstav = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
		        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
		        'Y', 'Z'};
	    char[] billettnr=new char[5];
	    Random random=new Random();
	    for (int i = 0; i < 5; i++) {
	    	billettnr[i]=bokstav[random.nextInt(bokstav.length)];
	    }
	    Kino listSelected = tabell.getSelectionModel().getSelectedItem();
	    
	    String billettnr2= new String (billettnr);  
	   
	    // Ny variant p� � gi brukeren plass p� kino. Sparer tid for alle
	    int setenr = ThreadLocalRandom.current().nextInt(1, 20 + 1);
	    int radnr = ThreadLocalRandom.current().nextInt(1, 15 + 1);
	    Statement utsagn = kontroll.forbindelse.createStatement();
	    String sql = "INSERT INTO tblbillett VALUES('"+ billettnr2 +"'," + listSelected.getVisningnr() + ", 0)";
	    utsagn.executeUpdate(sql);
	    String sql2 = "INSERT INTO tblplassbillett VALUES ("+ radnr + "," + setenr + "," + listSelected.getKinosalnr() + ",'"+ billettnr2 + "')";
		utsagn.executeUpdate(sql2);
		
		bookText.setText("Booket!");
	}
		
		

}

