package devandroid.wittmann.appminhaideia.controller;

import android.util.Log;

import devandroid.wittmann.appminhaideia.core.AppUtil;

public class ClienteController {

    String versaoApp;

    public ClienteController(){

        this.versaoApp = AppUtil.versaoDoAplicativo();

        Log.i(AppUtil.TAG,"ClienteController: Versão App: "+versaoApp);

    }


}
