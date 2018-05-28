package miprimerapp.android.teaching.com.miprimeraapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    //VERSIONES ANTERIORES A OREO

    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Map<String, String> data = remoteMessage.getData();
        remoteMessage.getData().toString();
        Log.d("Notificacion push", "El mensaje es: " + data.toString());
        if (data.containsKey("show_notification")) {
            //MOSTRAR NOTIFICACIÓN
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("HOLA CLASE")
                    .setContentText("Hoy estaís dormidos");

            NotificationManager manager = (NotificationManager)
                    getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(1, builder.build());
        }
    }

}
