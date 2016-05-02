package la.oja.eventify;

import android.util.Log;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.async.callback.BackendlessCallback;
import com.backendless.exceptions.BackendlessException;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.property.ObjectProperty;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class EventifyStoredProcedures
{
    EventifyStoredProcedures(){

    }

    public void registrarUsuario(){

        BackendlessUser user = new BackendlessUser();
        user.setEmail( "luna.ums@gmail.com" );
        user.setPassword( "my_super_password" );

        Backendless.UserService.register( user, new BackendlessCallback<BackendlessUser>()
        {
            @Override
            public void handleResponse( BackendlessUser backendlessUser )
            {
                Log.i( "Registration", backendlessUser.getEmail() + " successfully registered" );
            }
            @Override
            public void handleFault( BackendlessFault fault )
            {
                // an error has occurred, the error code can be retrieved with fault.getCode()
                Log.i("Registration", "Error de registro" + fault.getCode());
            }
        } );
    }

    public void loginUsuario(){
        Backendless.UserService.login( "luna.ums@gmail.com", "my_super_password", new AsyncCallback<BackendlessUser>()
        {
            public void handleResponse( BackendlessUser user )
            {
                Log.i("Registration", "Login correcto para " + user.getEmail());
            }

            public void handleFault( BackendlessFault fault )
            {
                Log.i("Registration", "Error de login " + fault.getCode());
            }
        });

    }

    public void logoutUsuario(){
        Backendless.UserService.logout( new AsyncCallback<Void>()
        {
            public void handleResponse( Void response )
            {
                Log.i("Registration", "Logout correcto");
            }

            public void handleFault( BackendlessFault fault )
            {
                Log.i("Registration", "Error de logout  " + fault.getCode());
            }
        });
    }

    public void guardarEvento(){
        Evento evento = new Evento();
        evento.setTitulo("Ejemplo 1");
        evento.setCategoria("Categoria ejemplo 1");
        evento.setEnlace("enlace ejemplo 1");

        Backendless.Persistence.save(evento, new AsyncCallback<Evento>() {
            @Override
            public void handleResponse(Evento evento) {
                Log.i("MENSAJE", "guardado " + evento.getTitulo());
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.i("MENSAJE", "error de guardado " + fault.getCode());
            }
        });
    }

    public void borrarEvento(){
        Evento evento = new Evento();
        evento.setTitulo("Ejemplo 1");
        evento.setCategoria("Categoria ejemplo 1");
        evento.setEnlace("enlace ejemplo 1");

        Backendless.Persistence.save(evento, new AsyncCallback<Evento>() {
            @Override
            public void handleResponse(Evento evento) {
                Log.i("MENSAJE", "guardado " + evento.getTitulo());
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.i("MENSAJE", "error de guardado " + fault.getCode());
            }
        });
    }

    public void  mostrarTodosLosEventos(){
        Backendless.Persistence.of( Evento.class).findFirst( new AsyncCallback<Evento>(){
            @Override
            public void handleResponse( Evento evento )
            {
                Log.i("MENSAJE","El primer registro es " +evento.getTitulo());

            }
            @Override
            public void handleFault( BackendlessFault fault )
            {
                // an error has occurred, the error code can be retrieved with fault.getCode()
            }
        });

    }

}