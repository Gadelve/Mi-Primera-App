package miprimerapp.android.teaching.com.miprimeraapp;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        //COMPROBAR REPOSITORIO PARA AÑADIR MEJROAS A ESTE METODO Y CAMBIAR LO DEL MANIFESTTAMBIEN!!!!
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("InstanceIdService", "RefreshedToken: " + refreshedToken);
    }
}
