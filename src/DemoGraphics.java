import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;

public class DemoGraphics extends Application
{
    private static final int MOVEMENT_GAP = 10;
    private static final int RADIUS_GAP = 5;
    
    @Override
  //************************************start()***************************************
    public void start (Stage stg)
    {
        StackPane pane = new StackPane();
        Circle c = new Circle(300, 200, 30, Color.RED);
        c.setOpacity(0.7);
        pane.getChildren().add(c);
        c.setManaged(false);
        
        stg.setTitle("Moving Circle");
        FlowPane root = new FlowPane(10, 10);
        root.setStyle("-fx-background-color: DAE6F3;");
        root.setAlignment(Pos.TOP_CENTER);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: DAE6F3;");
        borderPane.setCenter(pane);
        borderPane.setTop(root);
        BorderPane.setAlignment(root, Pos.CENTER);

        Scene sc = new Scene(borderPane, 600, 400);
        stg.setScene(sc);
        
        Button bUp = new Button("Up");
        Button bDown = new Button("Down");
        Button bLeft = new Button("Left");
        Button bRight = new Button("Right");
        Button bExpand = new Button("Expand");
        Button bShrink = new Button("Shrink");
        
        
        bUp.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent ae)
            {
                if (c.getCenterY() - c.getRadius() > 0)
                    c.setCenterY(c.getCenterY() - MOVEMENT_GAP);
            }
        });
        bDown.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent ae)
            {
                if (c.getCenterY() + c.getRadius() < 375)
                    c.setCenterY(c.getCenterY() + MOVEMENT_GAP);
            }
        });
        bLeft.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent ae)
            {
                if (c.getCenterX() - c.getRadius() > 0)
                c.setCenterX(c.getCenterX() - MOVEMENT_GAP);
            }
        });
        bRight.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent ae)
            {
                if (c.getCenterX() + c.getRadius() < 600)
                    c.setCenterX(c.getCenterX() + MOVEMENT_GAP);
            }
        });
        bExpand.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent ae)
            {
                if (c.getRadius() < 275)
                    c.setRadius(c.getRadius() + RADIUS_GAP);
            }
        });
        bShrink.setOnAction(new EventHandler <ActionEvent>()
        {
            public void handle(ActionEvent ae)
            {
                if (c.getRadius() >= 0)
                    c.setRadius(c.getRadius() - RADIUS_GAP);
            }
        });
       
        
        root.getChildren().addAll(bUp, bDown, bLeft, bRight, bExpand, bShrink);
        
        stg.setScene(sc);
        stg.show();
    }
    
  //**************************************main()**************************************
    public static void main(String[] args)
    {
        launch(args);
    }
}
