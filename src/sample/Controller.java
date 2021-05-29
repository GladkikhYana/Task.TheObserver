package sample;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Controller {
    public Canvas can;
    public TextField timer;    public TextField repeat;    public TextField clock;    public TextField coll;    public TextField dindon;
    public Label mess;
    public Button start;    public Button stop;    public Button clean;
    public Button stCount;    public Button spCount;
    public Button stColl;    public Button spColl;
    public Button stClock;    public Button spClock;

    Subject subject = new Subject();
    ComponentText ct;    
   Signal sl;
    ComponentClock ck;   
    GraphicsContext gr;
    @FXML
    public void initialize()
    {
    gr = can.getGraphicsContext2D();
    addObs();
    dindon.setEditable(false);
    dindon.setText("Прошло _ с");
    Clock clock = new Clock();
    Paint p = Color.KHAKI;
    clock.draw(gr,p,190,190,95,95,105);
    }
    public void addObs(){
        ct = new ComponentText(subject,dindon);
        sl = new Signal(subject);
        ck = new ComponentClock(subject,gr);
    }
    public void delObs()
    {
        ct.delComo(subject);
   sl.delComo(subject);
    ck.delComo(subject);
    }

    public void Start(ActionEvent actionEvent) {
        mess.setText("Таймер активен");
        subject.start(Integer.parseInt(timer.getText()),Integer.parseInt(repeat.getText()));
    }

    public void Stop(ActionEvent actionEvent) {
        mess.setText("Таймеростановлен");
        subject.stop();
    }

    public void Clean(ActionEvent actionEvent) {
        mess.setText("Таймернеактивен");
        timer.setText("");
        repeat.setText("");
        coll.setText("");
        clock.setText("");
        delObs();
        addObs();
        subject.clean();
    }

    public void startCount(ActionEvent actionEvent) {
    ct.onComp();
   }

    public void stopCount(ActionEvent actionEvent) {
        ct.offComp();
    }

    public void startColl(ActionEvent actionEvent) {
        sl.onComp(Integer.parseInt(coll.getText()));
    }

    public void stopColl(ActionEvent actionEvent) {
        sl.offComp();
    }

    public void startClock(ActionEvent actionEvent) {
        ck.onComp(Integer.parseInt(clock.getText()));

    }

    public void stopClock(ActionEvent actionEvent) {
        ck.offComp();
    }
}