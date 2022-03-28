package Grensesnitt;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

import Kontroll.Kontroll;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableController implements Initializable {

	Kontroll kontroll;
	
	@FXML
    private TableColumn<TableViewController, Date> col_tidspunkt;

    @FXML
    private TableView<TableViewController> tabell;

    @FXML
    private TableColumn<TableViewController, Integer> col_pris;

    @FXML
    private TableColumn<TableViewController, String> col_kinosalnr;

    @FXML
    private TableColumn<TableViewController, Integer> col_dato;

    @FXML
    private TableColumn<TableViewController, String> col_film;
    
    ObservableList<TableViewController> oblist = FXCollections.observableArrayList();
    
    public void initialize(URL location, ResourceBundle resources) {
		try{
			
			ResultSet rs = kontroll.forbindelse.createStatement().executeQuery("SELECT tblvisning.v_kinosalnr, tblvisning.v_dato, tblvisning.v_starttid, tblvisning.v_pris, tblfilm.f_filmnavn\r\n"
					+ "FROM tblvisning, tblfilm\r\n"
					+ "WHERE tblvisning.v_filmnr = tblfilm.f_filmnr\r\n"
					+ "ORDER BY tblvisning.v_dato ASC, tblvisning.v_starttid ASC");
					
			while (rs.next()) {
				oblist.add(new TableViewController(rs.getString("kinosalnr"), rs.getInt("dato"), rs.getDate("tidspunkt"), rs.getString("pris"), rs.getString("film")));
			}
		}	catch(SQLException ex) {
				Logger.getLogger(TableController.class.getName()).log(Level.SEVERE, null, ex);
		}
		col_kinosalnr.setCellValueFactory(new PropertyValueFactory<>("kinosalnr"));
		col_dato.setCellValueFactory(new PropertyValueFactory<>("dato"));
		col_tidspunkt.setCellValueFactory(new PropertyValueFactory<>("tidspunkt"));
		col_pris.setCellValueFactory(new PropertyValueFactory<>("pris"));
		col_film.setCellValueFactory(new PropertyValueFactory<>("film"));
		
		tabell.setItems(oblist);
		
	}
}
