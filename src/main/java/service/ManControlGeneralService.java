package service;

import modelo.MantenimientoControlGeneral;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

//esta clase puede ser probada en el navegador pero no tenemos :v un war, asi que tocara hacer unos test
@Path("mantenimiento")
public class ManControlGeneralService {
    private static List<MantenimientoControlGeneral> lista = controlador.Archivo.getCargarArchivoCG();

    @GET
    @Produces(MediaType.APPLICATION_JSON) //produce un json
    public  Response getMantenimientos(){

        //nos devolvera 200
        return Response.ok(lista).build();
    }

    //metodo para buscar uno en particular
    @GET
    @Path("/{id}")
    public Response getMantenimiento(@PathParam("id") int id){

        MantenimientoControlGeneral mantenimiento = new MantenimientoControlGeneral();
        mantenimiento.setIdMantenimiento(id);
        if(lista.contains(mantenimiento)){
            for(MantenimientoControlGeneral obj:lista){
                if (obj.getIdMantenimiento() == id){
                    // codigo 200
                    return Response.ok().build();
                }
            }
        }
        //codigo 404 no encontrado
        return  Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrarMantenimiento(@PathParam("id") int id){
        MantenimientoControlGeneral mantenimiento = new MantenimientoControlGeneral();
        mantenimiento.setIdMantenimiento(id);
        if(lista.contains(mantenimiento)){
            lista.remove(mantenimiento);
            return Response.ok().build();
        }
        return  Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarMantenimiento(MantenimientoControlGeneral mantenimiento){
        lista.add(mantenimiento);
        return Response.status(Response.Status.CREATED).entity(mantenimiento).build();
    }

    //falta el put
}
