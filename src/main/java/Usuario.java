import java.util.List;
import java.util.stream.Collectors;

public class Usuario {
  List<Guardarropa> guardarropaList;
  List<Sugerencia> sugerenciasHoy;
  List<Alerta> alertas;
  Meteorologo meteorologo;
  List<AlertaMeteorologica> alertaMeteorologicas;

  public List<Guardarropa> getGuardarropaList() {
    return guardarropaList;
  }

  public void darSugerencias(){
    sugerenciasHoy.addAll(guardarropaList.stream().map(guardarropa -> guardarropa.crearSugencia()).collect(Collectors.toList()));
  }

  public void verificarAlertas(){
    this.alertas = this.meteorologo.verAlertas();
    if(this.alertas.size() > 0){
      analizarAlerta();
      darSugerencias();
    }
  }

  private void analizarAlerta(){
    this.alertaMeteorologicas.stream().forEach(alertaMeteorologica -> alertaMeteorologica.ejecutar());
  }
}
