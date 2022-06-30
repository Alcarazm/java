package model;

public class DisqueraVo {

    private int idDisquera; 
    private String nitDisquera; 
    private String nombreDisquera;
    private String telefonoDisquera; 
    private String direccionDisquera;
    private boolean estadoDisquera;

    public DisqueraVo (){

    }
    public DisqueraVo (int idDisquera, String nitDisquera, String nombreDisquera, String telefonoDisquera,
                        String direccionDisquera, boolean estadoDisquera  ){
        this.idDisquera=idDisquera;
        this.nitDisquera=nitDisquera;
        this.nombreDisquera=nombreDisquera;
        this.telefonoDisquera=telefonoDisquera;
        this.direccionDisquera=direccionDisquera;
        this.estadoDisquera=estadoDisquera;

    }

    public int getidDisquera(){
        return idDisquera;
    }

    public void setidDisquera(int idDisquera){
        this.idDisquera=idDisquera;
    }

    public String getnitDisquera(){
        return nitDisquera;
    }

    public void setnitDisquera(String nitDisquera){
        this.nitDisquera=nitDisquera;
    }

    public String getnombreDisquera(){
        return nombreDisquera;
    }

    public void setnombreDisquera(String nombreDisquera){
        this.nombreDisquera=nombreDisquera;
    }

    public String gettelefonoDisquera(){
        return telefonoDisquera;
    }

    public void settelefonoDisquera(String telefonoDisquera){
        this.telefonoDisquera=telefonoDisquera;
    }

    public String getdireccionDisquera(){
        return direccionDisquera;
    }

    public void setdireccionDisquera(String direccionDisquera){
        this.direccionDisquera=direccionDisquera;
    }

    public boolean getestadoDisquera(){
        return estadoDisquera;
    }

    public void setestadoDisquera(Boolean estadoDisquera){
        this.estadoDisquera=estadoDisquera;
    }

    
}
