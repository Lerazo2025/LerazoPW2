package Repository;

import Model.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class DatabaseRepositoryImpl{
    private static DatabaseRepositoryImpl instance;
    private DatabaseClient client;
    private DatabaseRepositoryImpl(String url,long timeout){
        super();
        client=new DatabaseClient(url,timeout);



    }
    //Patron Singleton
    public static DatabaseRepositoryImpl getInstance(String url,long timeout){
        if(instance==null){
           synchronized(DatabaseRepositoryImpl.class){
               if(instance==null){
                   instance = new DatabaseRepositoryImpl(url,timeout);
               }
           }

        }
        return instance;
    }

    public VehiculosResponse consultarVehiculos() throws IOException {
     Call<VehiculosResponse> call=client.getInstance().listvehiculos();
     Response<VehiculosResponse> response = call.execute();
     if(response.isSuccessful()){
         return response.body();
     }
     else{
         return null;
     }
    }

    public boolean agregarVehiculo(Vehiculos vehiculo) throws IOException {
        Call<Void> call = client.getInstance().crearVehiculo(vehiculo);
        Response<Void> response = call.execute();

        if (response.isSuccessful()) {
            return true;
        } else {
            System.out.println("Error HTTP: " + response.code() + " - " + response.message());
            if (response.errorBody() != null) {
                System.out.println("Error Body: " + response.errorBody().string());
            }
            return false;
        }
    }

    public boolean actualizarVehiculo(Vehiculos vehiculos) {
        try {
            Call<Void> call = client.getInstance().actualizarVehiculo(vehiculos);
            Response<Void> response = call.execute();

            if (response.isSuccessful()) {
                System.out.println("Vehículo actualizado correctamente.");
                return true;
            } else {
                System.out.println("Error al actualizar vehículo: " + response.code() + " - " + response.message());
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarVehiculo(int id) {
        try {
            Call<Void> call = client.getInstance().eliminarVehiculo(id);
            Response<Void> response = call.execute();

            System.out.println("Código HTTP: " + response.code());
            System.out.println("Mensaje HTTP: " + response.message());
            if (response.errorBody() != null) {
                System.out.println("Error Body: " + response.errorBody().string());
            }

            return response.isSuccessful();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }



        //Conductores

    public ConductoresResponse consultarConductores() throws IOException {
        Call<ConductoresResponse> call = client.getInstance().listConductores();
        Response<ConductoresResponse> response = call.execute();
        if (response.isSuccessful()) {
            return response.body();
        }
        return null;
    }

    public boolean agregarConductor(Conductores conductor) throws IOException {
        Call<Void> call = client.getInstance().crearConductor(conductor);
        Response<Void> response = call.execute();
        return response.isSuccessful();
    }

    public boolean actualizarConductor(Conductores conductor) {
        try {
            Call<Void> call = client.getInstance().actualizarConductor(conductor);
            Response<Void> response = call.execute();

            if (response.isSuccessful()) {
                System.out.println("Vehículo actualizado correctamente.");
                return true;
            } else {
                System.out.println("Error al actualizar vehículo: " + response.code() + " - " + response.message());
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarconductor(int id) {
        try {
            Call<Void> call = client.getInstance().eliminarconductor(id);
            Response<Void> response = call.execute();

            System.out.println("Código HTTP: " + response.code());
            System.out.println("Mensaje HTTP: " + response.message());
            if (response.errorBody() != null) {
                System.out.println("Error Body: " + response.errorBody().string());
            }

            return response.isSuccessful();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }



    //Rutas

    public RutasResponse consultarRutas() throws IOException {
        Call<RutasResponse> call = client.getInstance().listRutas();
        Response<RutasResponse> response = call.execute();
        if (response.isSuccessful()) {
            return response.body();
        }
        return null;
    }

    public boolean agregarRuta(Rutas ruta) throws IOException {
        Call<Void> call = client.getInstance().crearRuta(ruta);
        Response<Void> response = call.execute();

        if (response.isSuccessful()) {
            return true;
        } else {
            System.out.println("Error HTTP: " + response.code() + " - " + response.message());
            if (response.errorBody() != null) {
                System.out.println("Error Body: " + response.errorBody().string());
            }
            return false;
        }
    }


    public boolean actualizarRuta(Rutas ruta) {
        try {
            Call<Void> call = client.getInstance().actualizarRuta(ruta);
            Response<Void> response = call.execute();

            if (response.isSuccessful()) {
                System.out.println("Ruta actualizada correctamente.");
                return true;
            } else {
                System.out.println("Error al actualizar Ruta: " + response.code() + " - " + response.message());
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean eliminarRuta(int id) {
        try {
            Call<Void> call = client.getInstance().eliminarRuta(id);
            Response<Void> response = call.execute();

            System.out.println("Código HTTP: " + response.code());
            System.out.println("Mensaje HTTP: " + response.message());
            if (response.errorBody() != null) {
                System.out.println("Error Body: " + response.errorBody().string());
            }

            return response.isSuccessful();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }






    //Mantenimiento

    public MantenimientoResponse consultarMantenimientos() throws IOException {
        Call<MantenimientoResponse> call = client.getInstance().listMantenimientos();
        Response<MantenimientoResponse> response = call.execute();
        if (response.isSuccessful()) {
            return response.body();
        }
        return null;
    }


    public boolean agregarMantenimiento(Mantenimiento mantenimiento) throws IOException {
        Call<Void> call = client.getInstance().crearMantenimiento(mantenimiento);
        Response<Void> response = call.execute();

        if (response.isSuccessful()) {
            return true;
        } else {
            System.out.println("Error HTTP: " + response.code() + " - " + response.message());
            if (response.errorBody() != null) {
                System.out.println("Error Body: " + response.errorBody().string());
            }
            return false;
        }
    }

    public boolean actualizarmantenimiento(Mantenimiento mantenimiento) throws IOException {
        try {
            Call<Void> call = client.getInstance().actualizarmantenimiento(mantenimiento);
            Response<Void> response = call.execute();

            if (response.isSuccessful()) {
                System.out.println("Mantenimiento actualizado correctamente.");
                return true;
            } else {
                System.out.println("Error al actualizar Mantenimiento: " + response.code() + " - " + response.message());
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }





    public boolean eliminarmantenimiento(int id) {
        try {
            Call<Void> call = client.getInstance().eliminarmantenimiento(id);
            Response<Void> response = call.execute();

            System.out.println("Código HTTP: " + response.code());
            System.out.println("Mensaje HTTP: " + response.message());
            if (response.errorBody() != null) {
                System.out.println("Error Body: " + response.errorBody().string());
            }

            return response.isSuccessful();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    //Combustible

    public CombustibleResponse consultarCombustibles() throws IOException {
        Call<CombustibleResponse> call = client.getInstance().listCombustibles();
        Response<CombustibleResponse> response = call.execute();
        return response.isSuccessful() ? response.body() : null;
    }

    public boolean agregarCombustible(Combustible combustible) throws IOException {
        Call<Void> call = client.getInstance().crearCombustible(combustible);
        Response<Void> response = call.execute();
        return response.isSuccessful();
    }

    public boolean actualizarCombustible(Combustible combustible) throws IOException {
        Call<Void> call = client.getInstance().actualizarCombustible(combustible);
        Response<Void> response = call.execute();
        return response.isSuccessful();
    }

    public boolean eliminarCombustible(int id) {
        try {
            Call<Void> call = client.getInstance().eliminarCombustible(id);
            Response<Void> response = call.execute();

            System.out.println("Código HTTP: " + response.code());
            System.out.println("Mensaje HTTP: " + response.message());
            if (response.errorBody() != null) {
                System.out.println("Error Body: " + response.errorBody().string());
            }
            return response.isSuccessful();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    //Seguimiento GPS

    public SeguimientoGPSResponse consultarSeguimientos() throws IOException {
        Call<SeguimientoGPSResponse> call = client.getInstance().listSeguimientos();
        retrofit2.Response<SeguimientoGPSResponse> response = call.execute();
        if (response.isSuccessful()) {
            return response.body();
        }
        return null;
    }

    public boolean agregarSeguimiento(SeguimientoGPS seguimiento) throws IOException {
        Call<Void> call = client.getInstance().agregarSeguimiento(seguimiento);
        retrofit2.Response<Void> response = call.execute();
        return response.isSuccessful();
    }

    public boolean actualizarSeguimiento(SeguimientoGPS seguimiento) throws IOException {
        Call<Void> call = client.getInstance().actualizarSeguimiento(seguimiento);
        retrofit2.Response<Void> response = call.execute();
        return response.isSuccessful();
    }

    public boolean eliminarSeguimiento(int id) throws IOException {
        Call<Void> call = client.getInstance().eliminarSeguimiento(id);
        retrofit2.Response<Void> response = call.execute();
        return response.isSuccessful();
    }



}
