import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/*  ========================================== 
 *  UoY MS CS [Algorithm & Data Structure]
 *  Summative Assessment 01 Week 5 30/05/2022
 *  @fileName: Shapes.java
 *  @author: 
 *  @version: V1 29/05/2022
 *  ==========================================
 */
 
public class Shapes extends Application {
	
	// Main method calls the Launch method with arguments received 
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    // create an Erase button that initialize the fields
    final Button eraseButton = new Button ("Erase");
    // create an Update button that modifies a shape
    final Button updateButton = new Button ("Shape Update");    
    // create and configure a Label that displays notifications
    final Label notification = new Label ();
    // create and configure a Label that displays text
    // when no shapes are selected
    final Label noShape = new Label ();
    
    
    // create and initialize variables for COMP 1
    int numPoly;
    char sideInput;
    String polygon;
    // create and initialize variables for COMP 2
    String color;
    
    
    @Override 
    public void start(Stage stage) {
    	
    	// declaring shapeComboBox starts here ************************************************//
    	
    	// declare a String type combo box to hold the shape types
    	ComboBox<String> shapeComboBox = new ComboBox<>();
    	
        // add the choices of shapes
        shapeComboBox.getItems().addAll(
            "3 -Triangle         ",
            "4 -Quadrilateral    ",
            "5 -Pentagon         ",
            "6 -Hexagon          ",
            "7 -Heptagon         "  
         );
        
        // set the initial text and attributes
        shapeComboBox.setPromptText("Number of sides of a polygon");
        shapeComboBox.setValue(polygon);
        shapeComboBox.setEditable(true);        
        shapeComboBox.setPrefWidth(250);
        
        // add a listener to the shape combo box
        shapeComboBox.valueProperty().addListener(new ChangeListener<String>() 
        { 	
        	@Override  // call the changed method when the value of shapeComboBox is changed
            public void changed(ObservableValue<? extends String> ov, String t, String t1) 
        	{           		
    	        // in case an exception is generated
        		try 
        		{	
                     // store the number in variable numPoly when the input is valid    
        	         if (t1 != null && t1.length() != 0 && !t1.matches("^\\s*$")) 
        	         {	
        	             // convert string to char for a single character
        	         	 sideInput = t1.charAt(0);
        	         	 // check if the first character is a digit
                         if ((sideInput >= '0') && (sideInput <= '9'))
                         {
        	        	     numPoly = Integer.parseInt(t1.substring(0,1));	
                         }
        	        	 else {
        	        	     numPoly = 0;	 
        	        	 }
        		     } 
        	         else 
        	         { 
        			     numPoly = 0; 
        			     
        		     	 // eliminate the whitespace in the input 
        			     // as it could cause an exception
        			     if (t1.matches("^\\s*$")) 
        		     	 {
        			         t1 = t1.trim();
        			         shapeComboBox.setValue(t1);
        		    	 } 
        	   	     }
        			
                     // edit the shape description according to the input number
                     switch (numPoly) 
                     {
                        case 3:
                	 	     polygon = "Triangle";
                		     break;
                        case 4:
                		     polygon = "Quadrilateral";
                		     break;
                	    case 5:
                		     polygon = "Pentagon";
                		     break;
                	    case 6:
                	         polygon = "Hexagon";
                		     break;
                	    case 7:
                	      	 polygon = "Heptagon";
                		     break;
                	    default:
                		     polygon = "Undefined input. An integer only.";
                		     break;
                     }
                }
        		// actions to take if something goes wrong
        		catch (Exception e) 
        		{
                	 System.out.println("Error when change shapeComboBox.");
                	 e.printStackTrace();
                }

            }    
        });
        // declaring shapeComboBox ends here **************************************************//
        
        // declaring colorComboBox starts here ************************************************//
        
        // declare a String type combo box to hold the colors
        ComboBox<String> colorComboBox = new ComboBox<>();
        
        // add the choices of colors
        colorComboBox.getItems().addAll(
            "RED",
            "GREEN",
            "GREY",
            "BLUE",
            "YELLOW" 
        );  
        
        // set the initial text and attributes
        colorComboBox.setPromptText("Color");
        colorComboBox.setValue(color);
        colorComboBox.setEditable(true); 
        colorComboBox.setPrefWidth(100);
        
        // add a listener to the color combo box
        colorComboBox.valueProperty().addListener(new ChangeListener<String>() 
        {    
        	@Override  // call the changed method when the value of colorComboBox is changed
            public void changed(ObservableValue<? extends String> ov2,  String s, String s1) 
        	{                
        		// in case an exception is generated
        		try 
        		{
        			 // store the color in variable color when the input is valid
        			 if (s1 != null && s1.length() != 0 && !s1.matches("^\\s*$")) 
        			 {
        			 	 color = s1.toUpperCase();
             		 } 
        			 else 
        			 { 
             		     color = ""; 
             		     // eliminate the whitespace in the input 
      			         // as it could cause an exception
             		     if (s1.matches("^\\s*$")) 
             		     {
         			         s1 = s1.trim();
         			         colorComboBox.setValue(s1);
         			     } 
             		 }

        		} 
        		// actions to take if something goes wrong
        		catch (Exception e) 
        		{
        			 System.out.println("Error when change colorComboBox.");
        			 e.printStackTrace();	
        		}
            }    
        });
        // declaring colorComboBox ends here **************************************************//
     
        // Creating a triangle & adding coordinates to the polygon
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(new Double[]
        {   
        	300.0, 100.0,
     	    150.0, 350.0,
   	        450.0, 350.0 
        });  
        
        // Creating a rectangle/quadrilateral
        Rectangle r = new Rectangle();
    	r.setX(150);
    	r.setY(150);
    	r.setWidth(250);
    	r.setHeight(250);
    	r.setArcWidth(10);
    	r.setArcHeight(10);
    	
    	// Creating a pentagon & adding coordinates to the polygon
    	Polygon pentagon = new Polygon();
        pentagon.getPoints().addAll(new Double[]
        {
            100.0, 200.0,
            180.0, 350.0,
            320.0, 350.0,
            400.0, 200.0,
            250.0, 100.0
        });
        
        // set text and font style to the labels
        notification.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 15));
        noShape.setText("No shape has been selected.");
        noShape.setFont(Font.font(null,20));
    	      
        // create a GridPane called grid to hold components 
    	GridPane grid = new GridPane();
     
        // supply the code that is executed when the erase button is pressed 
        eraseButton.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override // handle the event
            public void handle(ActionEvent e) 
            {
            	// in case an exception is generated
                try 
                {
                     // initialize combo boxes
                	 shapeComboBox.setValue("");
                     colorComboBox.setValue("");
                        
                     try 
                     {
                    	// clear current shape in row 2
                    	 grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 2); 
                     } 
                     catch (Exception x) 
                     {
                         System.out.println("Error when erase row 2 content.");
                         x.printStackTrace();
                     }
                         //show message on label noShape
                         grid.add(noShape, 1, 2);
                         
                         // show message to confirm the deletion
                         notification.setText("All inputs have been erased!"); 
                         notification.setTextFill(Color.GREEN);   
                }
                // actions to take if something goes wrong
                catch(Exception x) 
                {
                 	 System.out.println("Erasing function needs to be fixed.");
                 	 x.printStackTrace();
                }
            }
        });   	
    	    
        // supply the code that is executed when the update button is pressed         
        updateButton.setOnAction(new EventHandler<ActionEvent>() 
        {    
        	@Override // handle the event
            public void handle(ActionEvent e) 
        	{	
        		// reformat the notification label
            	notification.setTextFill(Color.RED);
            	notification.setText(""); 
	
            	// check validity of the input value of shape combo box
            	if (shapeComboBox.getValue().length() == 0 ||
                    shapeComboBox.getValue() == null)
            	{
            		 // in case an exception is generated
            		 try 
            		 {
                         notification.setText("Shape field must be filled out.");
            		 } 
            		 catch (Exception x) 
            		 {
            			 System.out.println("Shape input error.");
            			 x.printStackTrace();
            		 }
                }
            	
            	// check validity of the input value of color combo box
            	else if (colorComboBox.getValue() == null)
            	{
            		 // in case an exception is generated
            		 try 
            		 {
            		    notification.setText("Please enter/choose a color.");
            		 } 
            		 catch (Exception x) 
            		 {
            			System.out.println("Color input error.");
            			x.printStackTrace();
            		 }
            	} 
            	// colorComboBox can not be empty
            	else if (colorComboBox.getValue().length() == 0) 
            	{
             		 notification.setText("Color field must be filled out.");
            	}
            	
            	// currently only value of 3/4/5 are accepted
            	else if (numPoly != 3 && numPoly != 4 && numPoly != 5) 
            	{
            		 notification.setText("Currently only supports shape number 3 to 5.");
            	}
            	
            	// currently only 3 colors are accepted
            	// execute main function when valid inputs 
            	else if (color.contains("RED") || color.contains("GREEN") || color.contains("GREY")) 
            	{
            		 // confirm the inputs are valid and colored shape will be shown
            		 notification.setTextFill(Color.BLUE);
                     notification.setText("Lovely! It's a " + color + " " + polygon + ".");   
                     
                     // in case an exception is generated
                     try 
                     {
                    	 // prepare row 2 to show the shape
                         grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 2); 
                     } 
                     catch (Exception x) 
                     {
                    	 System.out.println("Error when initialize row 2 content.");
                    	 x.printStackTrace();
                      }
                     
                     // convert color to a valid Paint value
                     Paint pc = Paint.valueOf(color);
                     
                     // modify the shape and the color according to the values of variables
                     switch (numPoly) 
                     {
                         case 3:      	  
                             grid.add(triangle, 1, 2, 4, 1);  
                             triangle.setFill(Color.web(String.valueOf(pc)));
                             break;
                         case 4:
                             grid.add(r, 1, 2, 4, 1);
                             r.setFill(Color.web(String.valueOf(pc))); 
                             break;
                         case 5:
                             grid.add(pentagon, 1, 2, 4, 1);
                             pentagon.setFill(Color.web(String.valueOf(pc)));
                      	     break;
                         default:
                      	     break;
                     }
                      
            	}
                else 
                {
                        notification.setText("Currently only supports colors RED/GREEN/GREY.");
                }
            }
        });

   	    // configure a GridPane to hold the components          
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.add(new Label("Shapes: "), 0, 0);
        grid.add(shapeComboBox, 1, 0);
        grid.add(new Label("Colors: "), 2, 0);
        grid.add(colorComboBox, 3, 0);
        grid.add(eraseButton, 2, 1);
        grid.add(updateButton, 3, 1);
        grid.add(notification, 0, 1, 2, 1);
        grid.add(noShape, 1, 2);
        
        // in case an exception is generated when run the program
        try 
        {
            // create and configure a new scene
            Scene scene = new Scene(new Group(), 500, 350, Color.AZURE);
        
            // create a group that holds all the features 
            Group root = (Group)scene.getRoot();
        
            //add the grid to the group
            root.getChildren().add(grid);
        
            // add the scene to the stage, then set the title 
            stage.setScene(scene);
            stage.setTitle("FUN SHAPES");
        
            // show the stage 
            stage.show();
        } 
        catch(Exception e) 
        {
        	System.out.println("Stage Error.");
        	e.printStackTrace();
        }    
    }  // end of start method    
} // end of the class