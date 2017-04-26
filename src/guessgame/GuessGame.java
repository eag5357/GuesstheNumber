// Eric Galante
// CMPSC 221
 
package guessgame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessGame extends JFrame {
private int number, guess, highest, lowest;
private JTextField guessInput;
private JTextField message;
private JLabel prompt1, prompt2;
private JButton newGame;

public GuessGame()
{
super( "Guessing Game" );
prompt1 = new JLabel( "I have a number between 1 and 1000." );
prompt2 = new JLabel( "Can you guess my number? Enter your Guess:" );

highest = 0;
lowest = 1000;
guessInput = new JTextField( 5 );
guessInput.addActionListener( new GuessHandler( ) );
message = new JTextField( "Please enter your First Guess:", 17 );
message.setEditable( false );

newGame = new JButton( "New Game" );
newGame.addActionListener(
new ActionListener() {
public void actionPerformed( ActionEvent e ) {
message.setText( "Please enter your First Guess:" );
guessInput.setText( "" );
guessInput.setEditable( true );

getContentPane().setBackground(Color.LIGHT_GRAY);

theGame();
}
}
);

Container c = getContentPane();
c.setLayout( new FlowLayout() );
c.add( prompt1 );
c.add( prompt2 );
c.add( guessInput );
c.add( message );
c.add( newGame );
setSize( 300, 200 );
show();
theGame();
}

public void theGame()
{ number = ( int ) ( Math.random() * 1000 + 1 ); }

public static void main( String args[] )
{
GuessGame app = new GuessGame();

app.addWindowListener
        (
new WindowAdapter() 
{
public void windowClosing( WindowEvent e )
    {
        System.exit( 0 );
    }
}
        
);

}

class GuessHandler implements ActionListener
{
@Override
public void actionPerformed( ActionEvent e )
{
  
guess = Integer.parseInt( guessInput.getText() );

  

if ( guess > number )
{
message.setText( "Too High, Try Again!" );

if ( guess < lowest )
{
    lowest = guess;
    getContentPane().setBackground(Color.red); 
}
else
    getContentPane().setBackground(Color.blue); 
}

else if ( guess < number )
{
    message.setText( "Too Low, Try Again!" );

    if ( guess > highest ) 
    {
        highest = guess;
        getContentPane().setBackground(Color.red); 
    }
    else
        getContentPane().setBackground(Color.blue); 
}

else
    {
        message.setText( "Correct!" );
        getContentPane().setBackground( Color.white );
        guessInput.setEditable( false );
        lowest = 1000;
        highest = 0;
    }

repaint();

}

}

}