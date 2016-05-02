package la.oja.eventify;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class Evento
{
  private String categoria;
  private String enlace;
  private java.util.Date created;
  private String ownerId;
  private String objectId;
  private String titulo;
  private java.util.Date updated;
  private String enlaceImagen;
  public String getCategoria()
  {
    return categoria;
  }

  public void setCategoria( String categoria )
  {
    this.categoria = categoria;
  }

  public String getEnlace()
  {
    return enlace;
  }

  public void setEnlace( String enlace )
  {
    this.enlace = enlace;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getTitulo()
  {
    return titulo;
  }

  public void setTitulo( String titulo )
  {
    this.titulo = titulo;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getEnlaceImagen()
  {
    return enlaceImagen;
  }

  public void setEnlaceImagen( String enlaceImagen )
  {
    this.enlaceImagen = enlaceImagen;
  }

                                                    
  public Evento save()
  {
    return Backendless.Data.of( Evento.class ).save( this );
  }

  public Future<Evento> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Evento> future = new Future<Evento>();
      Backendless.Data.of( Evento.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Evento> callback )
  {
    Backendless.Data.of( Evento.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Evento.class ).remove( this );
  }

  public Future<Long> removeAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Long> future = new Future<Long>();
      Backendless.Data.of( Evento.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Evento.class ).remove( this, callback );
  }

  public static Evento findById( String id )
  {
    return Backendless.Data.of( Evento.class ).findById( id );
  }

  public static Future<Evento> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Evento> future = new Future<Evento>();
      Backendless.Data.of( Evento.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Evento> callback )
  {
    Backendless.Data.of( Evento.class ).findById( id, callback );
  }

  public static Evento findFirst()
  {
    return Backendless.Data.of( Evento.class ).findFirst();
  }

  public static Future<Evento> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Evento> future = new Future<Evento>();
      Backendless.Data.of( Evento.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Evento> callback )
  {
    Backendless.Data.of( Evento.class ).findFirst( callback );
  }

  public static Evento findLast()
  {
    return Backendless.Data.of( Evento.class ).findLast();
  }

  public static Future<Evento> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Evento> future = new Future<Evento>();
      Backendless.Data.of( Evento.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Evento> callback )
  {
    Backendless.Data.of( Evento.class ).findLast( callback );
  }

  public static BackendlessCollection<Evento> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Evento.class ).find( query );
  }

  public static Future<BackendlessCollection<Evento>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Evento>> future = new Future<BackendlessCollection<Evento>>();
      Backendless.Data.of( Evento.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Evento>> callback )
  {
    Backendless.Data.of( Evento.class ).find( query, callback );
  }
}