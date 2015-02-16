package com.example.mark.imtpmd;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener
{
    private ServerCommunicator serverCommunicator;
    private String receivedServerMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) this.findViewById( R.id.buttonsend );
        button.setOnClickListener( this );
    }


    //onClick methode die door de button wordt aangeroepen
    @Override
    public void onClick( View view )
    {
        //haal gegevens op uit de UI
        EditText editTextMessage = (EditText) this.findViewById( R.id.edittextmessage );
        String message = editTextMessage.getText().toString();

        EditText editTextIp = (EditText)findViewById(R.id.edittextip);
        String serverIp = editTextIp.getText().toString() ;

        EditText editTextPort = (EditText)findViewById(R.id.edittextport);
        int serverPort = Integer.parseInt( editTextPort.getText().toString() );

        //maak een nieuwe verbinding met de server
        this.serverCommunicator = new ServerCommunicator( this, serverIp, serverPort, message );

        //bij ontvangen van een bericht wordt de methode setReceivedServerMessage en run aangeroepen
        //om het bericht van de server binnen te halen en op het scherm te tonen
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}