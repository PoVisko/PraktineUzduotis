package com.Atsiliepimai.View;

import com.Atsiliepimai.Controller.Validation;
import com.Atsiliepimai.Model.Atsiliepimas;
import com.Atsiliepimai.Model.AtsiliepimasDao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Dashboard {
	private BorderPane bpRoot;
	private Scene scene;
	private Stage primaryStage;
	private TextField tfId;
	private TextField tfMiestas;
	private TextField tfVardas;
	private TextField tfPastas;
	private TextField tfAtsiliepimas;
	private GridPane gpAtsiliepimai;
	private ObservableList<Atsiliepimas> data = FXCollections.observableArrayList();
	 
	public Dashboard(Stage primaryStage){
		this.bpRoot = new BorderPane();
		scene = new Scene(this.bpRoot,1200,720);
		
		this.primaryStage=primaryStage;
		
		this.primaryStage.setScene(scene);
		this.primaryStage.setTitle("Atsiliepimai");
		this.primaryStage.setResizable(false);
		this.primaryStage.centerOnScreen();
		addElementsToScene();
		this.primaryStage.show();	
	}
	
	private void addElementsToScene (){
		Label lblId = new Label("ID:");
		Label lblMiestas = new Label("Miestas:");
		Label lblVardas = new Label("Vardas:");
		Label lblPastas = new Label("El. Pastas:");
		Label lblAtsiliepimas = new Label("Atsiliepimas:");
		
		tfId = new TextField ();
		tfMiestas = new TextField ();
		tfVardas = new TextField ();
		tfPastas = new TextField ();
		tfAtsiliepimas = new TextField ();
		
		Button btnAdd = new Button("Prideti");
		btnAdd.setMinWidth(100);
		Button btnEdit = new Button("Redaguoti");
		btnEdit.setMinWidth(100);
		Button btnDelete = new Button("Istrinti");
		btnDelete.setMinWidth(100);
		
		GridPane gpButtons = new GridPane();
		Insets insets = new Insets(10, 10, 10, 10);
		gpButtons.add(btnAdd,0,0);
		gpButtons.add(btnEdit,1,0);
		gpButtons.add(btnDelete,2,0);
		gpButtons.setPadding(insets);
		gpButtons.setAlignment(Pos.CENTER);
		GridPane.setMargin(btnAdd, insets);
		GridPane.setMargin(btnEdit, insets);
		GridPane.setMargin(btnDelete, insets);
		
		TableView table = new TableView();	
		table.setEditable(true);
		TableColumn colId = new TableColumn("id");
		colId.setMinWidth(20);
		TableColumn colVardas = new TableColumn("vardas");
		colVardas.setMinWidth(100);
		TableColumn colMiestas = new TableColumn("miestas");
		colMiestas.setMinWidth(100);
		TableColumn colPastas = new TableColumn("el. pastas");
		colPastas.setMinWidth(100);
		TableColumn colAtsiliepimas = new TableColumn("atsiliepimas");
		colAtsiliepimas.setMinWidth(280);
		 
		table.getColumns().addAll(colId,colVardas,colMiestas,colPastas,colAtsiliepimas);
		table.setMaxHeight(360);
			
		 colId.setCellValueFactory(
				 new PropertyValueFactory<Atsiliepimas,Integer>("id")
				);
		 colVardas.setCellValueFactory(
				 new PropertyValueFactory<Atsiliepimas,String>("vardas")
				);
		 colMiestas.setCellValueFactory(
				 new PropertyValueFactory<Atsiliepimas,String>("miestas")
				);
		 colPastas.setCellValueFactory(
				 new PropertyValueFactory<Atsiliepimas,String>("pastas")
				);
		 colAtsiliepimas.setCellValueFactory(
				 new PropertyValueFactory<Atsiliepimas,String>("atsiliepimas")
				);
			
			gpAtsiliepimai = new GridPane();
			gpAtsiliepimai.add(lblId,0,0);
			gpAtsiliepimai.add(tfId,1,0);
			gpAtsiliepimai.add(lblVardas,0,1);
			gpAtsiliepimai.add(tfVardas,1,1);
			gpAtsiliepimai.add(lblMiestas,0,2);
			gpAtsiliepimai.add(tfMiestas,1,2);
			gpAtsiliepimai.add(lblPastas,0,3);
			gpAtsiliepimai.add(tfPastas,1,3);
			gpAtsiliepimai.add(lblAtsiliepimas, 0, 4);
			gpAtsiliepimai.add(tfAtsiliepimas,1,4);
					
			gpAtsiliepimai.add(gpButtons,0,6,2,1);
			gpAtsiliepimai.setPadding(new Insets(10,10,10,10));
			gpAtsiliepimai.setVgap(10);
			gpAtsiliepimai.setHgap(10);
				
			bpRoot.setCenter(gpAtsiliepimai);
			bpRoot.setRight(table);
			
		 	AtsiliepimasDao atsiliepimasDao = new AtsiliepimasDao();
		 	atsiliepimasDao.showAtsiliepimai(data);
			table.setItems(data);
				
			btnAdd.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event){
				if(isValidInput("add")){
					Atsiliepimas atsiliepimas = new Atsiliepimas(
								tfVardas.getText().toString(),
								tfMiestas.getText().toString(),
								tfPastas.getText().toString(),
								tfAtsiliepimas.getText().toString()
						);
					atsiliepimasDao.addAtsiliepimas(atsiliepimas);
					table.getItems().clear();
					atsiliepimasDao.showAtsiliepimai(data);		
						}				
					}	
			});
			
			btnDelete.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                if (isValidInput("delete")) {
	                	for (Atsiliepimas atsiliepimas : data) {
	                        if (atsiliepimas.getId() == Integer.parseInt(tfId.getText().toString())) {
	                        	atsiliepimasDao.deleteAtsiliepimas(atsiliepimas.getId());
	                        }
	                    }
	                }
	                table.getItems().clear();
	                atsiliepimasDao.showAtsiliepimai(data);	
	            }
	        });
			
			btnEdit.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                if (isValidInput("edit")) {
	                    Atsiliepimas atsiliepimas = new Atsiliepimas(
	                            Integer.parseInt(tfId.getText().toString()),
	                            tfVardas.getText().toString(),
								tfMiestas.getText().toString(),
								tfPastas.getText().toString(),
								tfAtsiliepimas.getText().toString()
								);
	                    for (int i = 0; i < data.size(); i++) {
	                        if (atsiliepimas.getId() == data.get(i).getId()) {
	                        	atsiliepimasDao.editAtsiliepimas(atsiliepimas);
	                        }
	                    }
	                    table.getItems().clear();
	                    atsiliepimasDao.showAtsiliepimai(data);		
	                }
	            }
	        });
		}
	
	private boolean isValidInput(String action) {
		 switch (action) {
		 case "add":
        	if(!Validation.isValidName(tfVardas.getText().toString())){
				showAlert(Alert.AlertType.ERROR, gpAtsiliepimai.getScene().getWindow(), "Form Klaida!", "Miestas turi būti sudarytas tik i�? raidžių (min. 1 raidė)");
				return false;
			}else if(!Validation.isValidCity(tfMiestas.getText().toString())){
				showAlert(Alert.AlertType.ERROR, gpAtsiliepimai.getScene().getWindow(), "Form Klaida!", "Miestas turi būti sudarytas tik i�? raidžių (min. 3 raidės)");
				return false;
			}else if(!Validation.isValidEmail(tfPastas.getText().toString())){
				showAlert(Alert.AlertType.ERROR, gpAtsiliepimai.getScene().getWindow(), "Form Klaida!", "Netinkamas el. pa�?to formatas");
				return false;
			}else if(!Validation.isValidReview(tfAtsiliepimas.getText().toString())){
				showAlert(Alert.AlertType.ERROR, gpAtsiliepimai.getScene().getWindow(), "Form Klaida!", "Atsiliepimas neturi būti ilgesnis negu 280 simbolių");		
				return false;
			}else {			
			return true;
			}
        	
         case "delete":
        	 if(!Validation.isValidId(tfId.getText().toString())){
     			showAlert(Alert.AlertType.ERROR, gpAtsiliepimai.getScene().getWindow(), "Form Klaida!", "ID gali būti sudarytas tik i�? skaitmenų");
     			return false;
        	 }else {			
     			return true;
     			}
        	 
        default:
        	if(!Validation.isValidId(tfId.getText().toString())){
				showAlert(Alert.AlertType.ERROR, gpAtsiliepimai.getScene().getWindow(), "Form Klaida!", "ID gali būti sudarytas tik i�? skaitmenų");
				return false;
        	}else if(!Validation.isValidName(tfVardas.getText().toString())){
				showAlert(Alert.AlertType.ERROR, gpAtsiliepimai.getScene().getWindow(), "Form Klaida!", "Vardas negali turėti skaitmenų ir spec. simbolių, i�?skyrus -");
				return false;
        	}else if(!Validation.isValidCity(tfMiestas.getText().toString())){
				showAlert(Alert.AlertType.ERROR, gpAtsiliepimai.getScene().getWindow(), "Form Klaida!", "Miestas gali būti sudarytas tik i�? raidžių");
				return false;
        	}else if(!Validation.isValidEmail(tfPastas.getText().toString())){
				showAlert(Alert.AlertType.ERROR, gpAtsiliepimai.getScene().getWindow(), "Form Klaida!", "Netinkamas el. pa�?to formatas");
				return false;
			}else if(!Validation.isValidReview(tfAtsiliepimas.getText().toString())){
				showAlert(Alert.AlertType.ERROR, gpAtsiliepimai.getScene().getWindow(), "Form Klaida!", "Atsiliepimas neturi būti ilgesnis negu 280 simbolių");		
				return false;
			}else {			
			return true;
			}
		 }
	}
	
	private void showAlert(Alert.AlertType alerType, Window owner, String title, String message){
		Alert alert = new Alert(alerType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
		}
}
