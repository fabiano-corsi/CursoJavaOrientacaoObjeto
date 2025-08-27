package br.com.alura.consultacep.factory;

import br.com.alura.consultacep.adapter.ConsultaCepHistoricoJsonDecorator;
import br.com.alura.consultacep.adapter.ConsultaCepTxtFileDecorator;
import br.com.alura.consultacep.adapter.ConsultaCepViaCepImp;
import br.com.alura.consultacep.modelos.ConsultaCepInterfaceDeUsuario;
import br.com.alura.consultacep.modelos.ConsultaCepService;
import br.com.alura.consultacep.ui.console.ConsultaCepInterfaceDeUsuarioConsole;

public class SingletonFactory {
    private static SingletonFactory instance;
    private ConsultaCepService consultaCepService;
    private ConsultaCepInterfaceDeUsuario consultaCepInterfaceDeUsuario;

    private SingletonFactory() {
        ConsultaCepService consultaCepService = new ConsultaCepViaCepImp();
        ConsultaCepService consultaCepServiceJson = new ConsultaCepHistoricoJsonDecorator(consultaCepService);
        this.consultaCepService = new ConsultaCepTxtFileDecorator(consultaCepServiceJson);

        this.consultaCepInterfaceDeUsuario = new ConsultaCepInterfaceDeUsuarioConsole();
    }

    public static SingletonFactory getInstance() {
        if (instance == null) {
            instance = new SingletonFactory();
        }
        return instance;
    }

    public ConsultaCepService getConsultaCepService() {
        return consultaCepService;
    }

    public ConsultaCepInterfaceDeUsuario getconsultaCepInterfaceDeUsuario() {
        return consultaCepInterfaceDeUsuario;
    }
}
