package service;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.MantenimientoHistorialPreventivo;

/**
 *
 * @author yisus
 */
@Path("manControlPreventivoService")
public class ManHistorialPreventivoService {
    private static List<MantenimientoHistorialPreventivo> lista = controlador.Archivo.getCargarArchivoHP();

    @GET
    @Produces(MediaType.APPLICATION_JSON) //produce un json
    public  Response getMantenimientosPreventivoService(){

        //nos devolvera 200
        return Response.ok(lista).build();
    }

    //metodo para buscar uno en particular
    @GET
    @Path("/{id}")
    public Response getMantenimientoPreventivoService(@PathParam("id") int id){

        MantenimientoHistorialPreventivo mantenimiento = new MantenimientoHistorialPreventivo();
        mantenimiento.setId(id);
        if(lista.contains(mantenimiento)){
            for(MantenimientoHistorialPreventivo obj:lista){
                if (obj.getId()== id){
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
    public Response borrarMantenimientoPreventivoService(@PathParam("id") int id){
        MantenimientoHistorialPreventivo mantenimiento = new MantenimientoHistorialPreventivo();
        mantenimiento.setId(id);
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
    public Response guardarMantenimiento(MantenimientoHistorialPreventivo mantenimientoHP){
        lista.add(mantenimientoHP);
        return Response.status(Response.Status.CREATED).entity(mantenimientoHP).build();
    }

    //falta el put
}
