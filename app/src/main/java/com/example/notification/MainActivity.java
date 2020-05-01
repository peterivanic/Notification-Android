package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view){
        createNotification();
    }

    private void createNotification(){
        Intent intent = new Intent(this,MainActivity.class);

        PendingIntent pIntent = PendingIntent.getActivity(this,0,intent,0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Title of notification");
        builder.setContentText("This is the text of notification...");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setAutoCancel(true);
        builder.setContentIntent(pIntent);
        builder.setSmallIcon(R.mipmap.ic_launcher);

        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);

        Notification notification = builder.build();

        notificationManagerCompat.notify(new Random().nextInt(),notification);
    }
}
