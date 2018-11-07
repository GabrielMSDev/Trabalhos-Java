/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_times;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Gabriel
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML private TextField n_Jogos;
    @FXML private TextField equipe;
    @FXML private TextField pontos;
    @FXML private TextField n_Vit;
    @FXML private TextField n_Der;
    @FXML private TextField n_Emp;
    @FXML private TextField gol_Contra;
    @FXML private TextField gol_Favor;
    @FXML private TextArea apresentacao;
    @FXML private Label m_aproveitamento;
    @FXML private Label m_vit;
    @FXML private Label m_atk;
    @FXML private Label m_def;
    int c_vit = 0;
    int maior_vit = 0;
    int cm_atk = 0;
    int maior_atk = 0;
    int cm_def = 0;
    int maior_def = 1000;
    double n_jgs = 0;
    double pts_Disp = 0;
    int pts_Vit = 0;
    int pts_Ept = 0;
    int nv = 0;
    double maior_aprov = 0;
    double c_aprov = 0;
    double aproveitamento = 0;
    double pts = 0;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {

        c_vit = Integer.parseInt(n_Vit.getText()); //Maior Vit
        if(maior_vit < c_vit){
            maior_vit = c_vit;
            m_vit.setText(equipe.getText());
        }
        
        cm_atk = Integer.parseInt(gol_Favor.getText()); //Maior Atk
        if(maior_atk < cm_atk){
            maior_atk = cm_atk;
            m_atk.setText(equipe.getText());
        }
        
        cm_def = Integer.parseInt(gol_Contra.getText()); //Maior Defesa
        if(cm_def < maior_def){
            maior_def = cm_def;
            m_def.setText(equipe.getText());
        }
        
        n_jgs = Double.parseDouble(n_Jogos.getText()); //aproveitamento
        pts_Disp = n_jgs * 3;
        pts = Double.parseDouble(pontos.getText());
        c_aprov = (pts / pts_Disp)*100; 
        System.out.println(c_aprov);
        if(maior_aprov < c_aprov){
            maior_aprov = c_aprov;
            m_aproveitamento.setText(equipe.getText());
        }
        
        apresentacao.setText("Numero de Jogos: "+n_Jogos.getText()+";\nEquipe: "+equipe.getText()+""
                +";\nPontos: "+pontos.getText()+";\nNumero de Vitorias: "+n_Vit.getText()+""
                +";\nNumero de Derrotas: "+n_Der.getText()+";\nNumero de Empates: "+n_Emp.getText()+""
                +";\nGols Contra: "+gol_Contra.getText()+";\nGols a Favor: "+gol_Favor.getText());
        try{
            FileWriter fr = new FileWriter("C://Users//Gabriel//Documents//arquivo.txt",false);
            BufferedWriter esc = new BufferedWriter(fr);
            String conteudo = apresentacao.getText();
            esc.append(conteudo);
            esc.close();
            }
        catch(IOException e){
            e.printStackTrace();
            }
        n_Jogos.clear();
        equipe.clear();
        pontos.clear();
        n_Vit.clear();
        n_Der.clear();
        n_Emp.clear();
        gol_Contra.clear();
        gol_Favor.clear();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
