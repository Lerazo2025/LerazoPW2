package Repository;

import Model.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface DatabaseRepository {

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    //Vehiculos
    @GET("/pls/apex/uth_lerazodatabase/app.GestionTransporte/VEHICULOS")
    Call<VehiculosResponse> listvehiculos();


    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @POST("/pls/apex/uth_lerazodatabase/app.GestionTransporte/VEHICULOS")
    Call<Void> crearVehiculo(@Body Vehiculos vehiculo);



    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @PUT("/pls/apex/uth_lerazodatabase/app.GestionTransporte/VEHICULOS")
    Call<Void> actualizarVehiculo(@Body Vehiculos vehiculo);


    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @DELETE("/pls/apex/uth_lerazodatabase/app.GestionTransporte/VEHICULOS")
    Call<Void> eliminarVehiculo(@Query("id") int id);



    // Conductores
    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET("/pls/apex/uth_lerazodatabase/app.GestionTransporte/CONDUCTORES")
    Call<ConductoresResponse> listConductores();

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @POST("/pls/apex/uth_lerazodatabase/app.GestionTransporte/CONDUCTORES")
    Call<Void> crearConductor(@Body Conductores conductor);

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @PUT("/pls/apex/uth_lerazodatabase/app.GestionTransporte/CONDUCTORES")
    Call<Void> actualizarConductor(@Body Conductores conductor);

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @DELETE("/pls/apex/uth_lerazodatabase/app.GestionTransporte/CONDUCTORES")
    Call<Void> eliminarconductor(@Query("id") int id);


    // Rutas

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })

    @GET("/pls/apex/uth_lerazodatabase/app.GestionTransporte/RUTA")
    Call<RutasResponse> listRutas();

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })

    @POST("/pls/apex/uth_lerazodatabase/app.GestionTransporte/RUTA")
    Call<Void> crearRuta(@Body Rutas ruta);

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })

    @PUT("/pls/apex/uth_lerazodatabase/app.GestionTransporte/RUTA")
    Call<Void> actualizarRuta(@Body Rutas ruta);

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @DELETE("/pls/apex/uth_lerazodatabase/app.GestionTransporte/RUTA")
    Call<Void> eliminarRuta(@Query("id") int id);




    // Mantenimiento
    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET("/pls/apex/uth_lerazodatabase/app.GestionTransporte/MANTENIMIENTO")
    Call<MantenimientoResponse> listMantenimientos();

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @POST("/pls/apex/uth_lerazodatabase/app.GestionTransporte/MANTENIMIENTO")
    Call<Void> crearMantenimiento(@Body Mantenimiento mantenimiento);


    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @PUT("/pls/apex/uth_lerazodatabase/app.GestionTransporte/MANTENIMIENTO")
    Call<Void> actualizarmantenimiento(@Body Mantenimiento mantenimiento);


    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @DELETE("/pls/apex/uth_lerazodatabase/app.GestionTransporte/MANTENIMIENTO")
    Call<Void> eliminarmantenimiento(@Query("id") int id);


    // Combustible
    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET("/pls/apex/uth_lerazodatabase/app.GestionTransporte/COMBUSTIBLE")
    Call<CombustibleResponse> listCombustibles();

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @POST("/pls/apex/uth_lerazodatabase/app.GestionTransporte/COMBUSTIBLE")
    Call<Void> crearCombustible(@Body Combustible combustible);

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @PUT("/pls/apex/uth_lerazodatabase/app.GestionTransporte/COMBUSTIBLE")
    Call<Void> actualizarCombustible(@Body Combustible combustible);

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @DELETE("/pls/apex/uth_lerazodatabase/app.GestionTransporte/COMBUSTIBLE")
    Call<Void> eliminarCombustible(@Query("id") int id);


    // Seguimiento GPS
    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET("/pls/apex/uth_lerazodatabase/app.GestionTransporte/SEGUIMIENTOGPS")
    Call<SeguimientoGPSResponse> listSeguimientos();

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @POST("/pls/apex/uth_lerazodatabase/app.GestionTransporte/SEGUIMIENTOGPS")
    Call<Void> agregarSeguimiento(@Body SeguimientoGPS seguimiento);

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @PUT("/pls/apex/uth_lerazodatabase/app.GestionTransporte/SEGUIMIENTOGPS")
    Call<Void> actualizarSeguimiento(@Body SeguimientoGPS seguimiento);

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @DELETE("/pls/apex/uth_lerazodatabase/app.GestionTransporte/SEGUIMIENTOGPS")
    Call<Void> eliminarSeguimiento(@Query("id") int id);


}