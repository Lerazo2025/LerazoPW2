package View;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String usuario;
    private String password;

    // Getters y Setters
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    // Método que valida usuario y contraseña llamando al servicio APEX

    public void validarLogin() {
        try {

            String urlStr = "https://apex.oracle.com/pls/apex/uth_lerazodatabase/app.GestionTransporte/USUARIOS"
                    + "?usuario=" + URLEncoder.encode(usuario, "UTF-8")
                    + "&password=" + URLEncoder.encode(password, "UTF-8");

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();


            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            int status = conn.getResponseCode();

            if (status == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder respuesta = new StringBuilder();
                String linea;
                while ((linea = br.readLine()) != null) {
                    respuesta.append(linea);
                }
                br.close();

                String json = respuesta.toString();


                if (json.contains("\"login\":true")) {
                    // Mensaje de éxito
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO, "Login exitoso", null));

                    FacesContext.getCurrentInstance().getExternalContext().redirect("Menu.xhtml");
                } else {
                    // Mensaje de error de login
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrectos", null));
                }
            } else {
                // Error al conectar con el servidor
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conexión con el servidor", null));
            }

            conn.disconnect();

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: " + e.getMessage(), null));
        }
    }
}